package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.Community;
import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.repository.CommunityRepository;

@Service
public class CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    // Create a new community
    public Community createCommunity(Community community) {
        return communityRepository.save(community);
    }

    // Get all communities
    public List<Community> getAllCommunities() {
        return communityRepository.findAll();
    }

    // Get a community by ID
    public Optional<Community> getCommunityById(String id) {
        return communityRepository.findById(id);
    }

    // Get communities by hobby
    public List<Community> getCommunitiesByHobby(String hobby) {
        return communityRepository.findByHobby(hobby);
    }

    // Add a user to a community
    public Community addUserToCommunity(String communityId, String userId) {
        Optional<Community> optionalCommunity = communityRepository.findById(communityId);
        if (optionalCommunity.isPresent()) {
            Community community = optionalCommunity.get();
            community.getMembers().add(userId);
            return communityRepository.save(community);
        }
        return null; // Handle case when community not found
    }
}
