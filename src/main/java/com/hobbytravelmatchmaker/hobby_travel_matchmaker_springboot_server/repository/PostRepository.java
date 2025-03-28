package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // Find posts by community ID
    List<Post> findByCommunityId(String communityId);

    // Find posts by user ID
    List<Post> findByUserId(String userId);
}
