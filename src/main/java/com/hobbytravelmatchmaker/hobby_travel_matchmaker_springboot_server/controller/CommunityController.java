package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.Community;
import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.service.CommunityService;

@RestController
@RequestMapping("/api/communities")
// @CrossOrigin(origins = "http://localhost:3000") // Adjust for frontend
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    // Create a new community
    @PostMapping
    public Community createCommunity(@RequestBody Community community) {
        return communityService.createCommunity(community);
    }

    // Get all communities
    @GetMapping
    public List<Community> getAllCommunities() {
        return communityService.getAllCommunities();
    }

    // Get a community by ID
    @GetMapping("/{id}")
    public Optional<Community> getCommunityById(@PathVariable String id) {
        return communityService.getCommunityById(id);
    }

    // Get communities by hobby
    @GetMapping("/hobby/{hobby}")
    public List<Community> getCommunitiesByHobby(@PathVariable String hobby) {
        return communityService.getCommunitiesByHobby(hobby);
    }

    // Add a user to a community
    @PostMapping("/{communityId}/addUser/{userId}")
    public Community addUserToCommunity(@PathVariable String communityId, @PathVariable String userId) {
        return communityService.addUserToCommunity(communityId, userId);
    }
}
