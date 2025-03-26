package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    // Find User by Personal Email
    Optional<User> findByPersonalEmail(String email);

    // Find User by Credentials Username
    Optional<User> findByCredentialsUsername(String username);
}