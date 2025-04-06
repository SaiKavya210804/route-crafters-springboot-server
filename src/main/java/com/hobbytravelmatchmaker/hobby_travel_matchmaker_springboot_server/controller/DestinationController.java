package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.controller;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.Destination;
import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
@RequiredArgsConstructor
public class DestinationController {

    private final DestinationService destinationService;

    // ✅ Get all destinations
    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestinations() {
        List<Destination> destinations = destinationService.getAllDestinations();
        return ResponseEntity.ok(destinations);
    }

    // ✅ Get recommendations by one or more hobbies
    @GetMapping("/recommend/hobbies")
    public ResponseEntity<List<Destination>> getRecommendationsByHobbies(
            @RequestParam List<String> interests) {
        System.out.println("✅ Received Interests: " + interests);
        List<Destination> recommendations = destinationService.getDestinationsByInterests(interests);
        return ResponseEntity.ok(recommendations);
    }

    // ✅ Get recommendations by season (best time to visit)
    @GetMapping("/recommend/seasons")
    public ResponseEntity<List<Destination>> getRecommendationsBySeason(
            @RequestParam("bestTime") List<String> bestTime) {
        System.out.println("✅ Received Months: " + bestTime);
        List<Destination> recommendations = destinationService.getDestinationsByBestTime(bestTime);
        return ResponseEntity.ok(recommendations);
    }

    // ✅ Get detailed insight by destination name
    @GetMapping("/insight/{name}")
    public ResponseEntity<Destination> getDestinationInsight(@PathVariable String name) {
        Destination destination = destinationService.getDestinationByName(name);
        if (destination != null) {
            return ResponseEntity.ok(destination);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
