package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.repository;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.DestinationInsights;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DestinationInsightsRepository extends MongoRepository<DestinationInsights, String> {
    Optional<DestinationInsights> findByDestinationName(String destinationName);
}
