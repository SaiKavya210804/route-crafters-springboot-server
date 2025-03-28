package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.Post;
import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.service.PostService;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3000") // Adjust for frontend
public class PostController {

    @Autowired
    private PostService postService;

    // Create a new post
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    // Get all posts
    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    // Get a post by ID
    @GetMapping("/{postId}")
    public Optional<Post> getPostById(@PathVariable String postId) {
        return postService.getPostById(postId);
    }

    // Get posts by community ID
    @GetMapping("/community/{communityId}")
    public List<Post> getPostsByCommunity(@PathVariable String communityId) {
        return postService.getPostsByCommunity(communityId);
    }

    // Get posts by user ID
    @GetMapping("/user/{userId}")
    public List<Post> getPostsByUser(@PathVariable String userId) {
        return postService.getPostsByUser(userId);
    }

    // Delete a post
    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable String postId) {
        postService.deletePost(postId);
        return "Post deleted successfully";
    }
}
