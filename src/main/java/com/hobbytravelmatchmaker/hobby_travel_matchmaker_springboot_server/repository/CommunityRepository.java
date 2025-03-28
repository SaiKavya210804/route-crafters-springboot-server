package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.Community;

@Repository
public interface CommunityRepository extends MongoRepository<Community, String> {

    // Find communities by hobby
    List<Community> findByHobby(String hobby);

    // Find communities created by a specific user
    List<Community> findByCreatedBy(String createdBy);

    // Find a community by name (optional, case-sensitive)
    Community findByName(String name);
}
