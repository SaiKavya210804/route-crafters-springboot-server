package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.Post;
import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // Create a new post
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    // Get all posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Get a post by ID
    public Optional<Post> getPostById(String postId) {
        return postRepository.findById(postId);
    }

    // Get posts by Community ID
    public List<Post> getPostsByCommunity(String communityId) {
        return postRepository.findByCommunityId(communityId);
    }

    // Get posts by User ID
    public List<Post> getPostsByUser(String userId) {
        return postRepository.findByUserId(userId);
    }

    // Delete a post
    public void deletePost(String postId) {
        postRepository.deleteById(postId);
    }
}
