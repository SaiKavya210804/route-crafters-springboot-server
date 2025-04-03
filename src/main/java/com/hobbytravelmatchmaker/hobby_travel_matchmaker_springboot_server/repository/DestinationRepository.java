package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.repository;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.Destination;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface DestinationRepository extends MongoRepository<Destination, String> {
    List<Destination> findByInterestsIn(List<String> interests);

    // New queries for insights
    List<Destination> findByBestTimeToVisit(String bestTime);

    List<Destination> findByPopularActivitiesContaining(String activity);

    List<Destination> findByCulturalHighlightsContaining(String highlight);
}
