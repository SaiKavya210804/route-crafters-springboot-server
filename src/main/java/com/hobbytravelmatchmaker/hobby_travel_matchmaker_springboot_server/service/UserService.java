package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.exception.UserNotFoundException;
import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.User;
import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.repository.UserRepository;
import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.security.JwtUtil;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 1️⃣ Create User (Register)
    public User saveUser(User user) {
        // Hash the password before saving
        user.getCredentials().setPassword(passwordEncoder.encode(user.getCredentials().getPassword()));

        return userRepository.save(user);
    }

    // 2️⃣ Login & Generate JWT
    public String loginUser(String username, String password) {
        User user = userRepository.findByCredentialsUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Invalid credentials"));

        if (!passwordEncoder.matches(password, user.getCredentials().getPassword())) {
            throw new UserNotFoundException("Invalid credentials");
        }

        return jwtUtil.generateToken(user.getCredentials().getUsername());
    }

    // 3️⃣ Get User from Token
    public User getUserFromToken(String token) {
        if (token == null || token.isEmpty()) {
            throw new UserNotFoundException("No authentication token found.");
        }

        // Validate token and extract username
        Optional<String> extractedUsername = jwtUtil.extractUsername(token);
        if (extractedUsername.isEmpty()) {
            throw new UserNotFoundException("Invalid or expired token.");
        }

        // Fetch user from the database
        User user = userRepository.findByCredentialsUsername(extractedUsername.get())
                .orElseThrow(() -> new UserNotFoundException("User not found for token."));

        // Revalidate token for extra security
        if (!jwtUtil.validateToken(token, user.getCredentials().getUsername())) {
            throw new UserNotFoundException("Invalid token for this user.");
        }

        return user;
    }

    // 4️⃣ Update User
    public User updateUser(String id, User updatedUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        // Update the fields
        user.setPersonal(updatedUser.getPersonal());
        user.setAddress(updatedUser.getAddress());
        user.setLanguages(updatedUser.getLanguages());
        user.setHobbies(updatedUser.getHobbies());
        user.setCredentials(updatedUser.getCredentials());
        user.setRole(updatedUser.getRole());

        return userRepository.save(user);
    }

    // 5️⃣ Delete User
    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }
}
