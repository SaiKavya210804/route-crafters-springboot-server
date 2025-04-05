package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.repository;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.Destination;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DestinationRepository extends MongoRepository<Destination, String> {
    List<Destination> findByInterestsIn(List<String> interests);

    List<Destination> findByBestTimeToVisit(List<String> bestTime);

    List<Destination> findByPopularActivitiesContaining(String activity);

    List<Destination> findByCulturalHighlightsContaining(String highlight);

    // ✅ For insights popup (search by name, case-insensitive)
    Destination findByNameIgnoreCase(String name);

    List<Destination> findByBestTimeToVisitInIgnoreCase(List<String> bestTime);
}
