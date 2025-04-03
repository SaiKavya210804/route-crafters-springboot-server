package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.controller;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.Destination;
import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/destinations")
@RequiredArgsConstructor
public class DestinationController {

    private final DestinationService destinationService;

    // Get all destinations
    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestinations() {
        List<Destination> destinations = destinationService.getAllDestinations();
        return ResponseEntity.ok(destinations);
    }

    // Get recommendations based on hobbies (interests)
    @PostMapping("/recommend/hobbies")
    public ResponseEntity<List<Destination>> getRecommendationsByHobbies(
            @RequestBody Map<String, List<String>> request) {
        List<String> interests = request.get("interests");
        System.out.println("✅ Received Interests: " + interests);
        List<Destination> recommendations = destinationService.getDestinationsByInterests(interests);
        return ResponseEntity.ok(recommendations);
    }

    // Get recommendations based on seasons (best time to visit)
    @PostMapping("/recommend/seasons")
    public ResponseEntity<List<Destination>> getRecommendationsBySeason(@RequestBody Map<String, String> request) {
        String bestTime = request.get("season");
        System.out.println("✅ Received Season: " + bestTime);
        List<Destination> recommendations = destinationService.getDestinationsByBestTime(bestTime);
        return ResponseEntity.ok(recommendations);
    }
}
