package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.service;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.Destination;
import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationService {

    private final DestinationRepository destinationRepository;

    // ✅ Get all destinations
    public List<Destination> getAllDestinations() {
        System.out.println("📦 Fetching all destinations...");
        return destinationRepository.findAll();
    }

    // ✅ Get destinations by list of interests (hobbies)
    public List<Destination> getDestinationsByInterests(List<String> interests) {
        List<String> lowerCaseInterests = interests.stream()
                .map(String::toLowerCase)
                .toList();
        System.out.println("🔍 Searching for destinations matching interests: " + lowerCaseInterests);
        List<Destination> results = destinationRepository.findByInterestsIn(lowerCaseInterests);
        System.out.println("✅ Found destinations: " + results.size());
        return results;
    }

    // ✅ Get destinations by best visiting season
    public List<Destination> getDestinationsByBestTime(List<String> bestTime) {
        System.out.println("🔍 Searching for destinations with best time: " + bestTime);
        // List<Destination> results =
        // destinationRepository.findByBestTimeToVisit(bestTime);
        List<Destination> results = destinationRepository.findByBestTimeToVisitInIgnoreCase(bestTime);

        System.out.println("✅ Found destinations: " + results.size());
        return results;
    }

    // ✅ Get a destination by name (for insight popup)
    public Destination getDestinationByName(String name) {
        System.out.println("🔎 Getting destination by name: " + name);
        Destination destination = destinationRepository.findByNameIgnoreCase(name);
        if (destination != null) {
            System.out.println("✅ Destination found: " + destination.getName());
        } else {
            System.out.println("❌ No destination found with name: " + name);
        }
        return destination;
    }
}
