package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.Place;
import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.service.PlaceService;

@RestController
@RequestMapping("/api/places")
@CrossOrigin(origins = "http://localhost:3000") // Adjust for your frontend URL
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/{hobby}")
    public List<Place> getPlaces(@PathVariable String hobby) {
        return placeService.getPlacesByHobby(hobby);
    }
}
