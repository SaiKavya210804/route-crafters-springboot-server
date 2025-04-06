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
// @CrossOrigin(origins = "http://localhost:3000") // Adjust if needed
public class DestinationController {

    private final DestinationService destinationService;

    // Get all destinations
    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestinations() {
        List<Destination> destinations = destinationService.getAllDestinations();
        return ResponseEntity.ok(destinations);
    }

    // Get recommendations based on interests
    @PostMapping("/recommend")
    public ResponseEntity<List<Destination>> getRecommendations(@RequestBody Map<String, List<String>> request) {
        List<String> interests = request.get("interests");
        System.out.println("✅ Received Interests: " + interests);
        List<Destination> recommendations = destinationService.getDestinationsByInterests(interests);
        return ResponseEntity.ok(recommendations);
    }

}