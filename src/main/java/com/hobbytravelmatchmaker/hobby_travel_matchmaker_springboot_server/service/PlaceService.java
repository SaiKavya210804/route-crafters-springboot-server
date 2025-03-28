package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.service;


import java.util.*;

import org.springframework.stereotype.Service;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.Place;

@Service
public class PlaceService {

    private static final Map<String, List<Place>> hobbyPlaces = new HashMap<>();

    static {
        hobbyPlaces.put("photography", Arrays.asList(
            new Place("Santorini, Greece", "/images/santorini.jpg", "Famous for its white-washed buildings, blue domes, and stunning sunsets."),
            new Place("Grand Canyon, USA", "/images/grand_canyon.jpg", "A breathtaking natural wonder with incredible landscapes and lighting."),
            new Place("Kyoto, Japan", "/images/kyoto.jpg", "Home to beautiful temples, cherry blossoms, and historic streets."),
            new Place("Bali, Indonesia", "/images/bali.jpg", "Lush rice terraces, stunning beaches, and cultural temples make it a paradise for photographers.")
        ));
    }

    public List<Place> getPlacesByHobby(String hobby) {
        return hobbyPlaces.getOrDefault(hobby.toLowerCase(), Collections.emptyList());
    }
}
