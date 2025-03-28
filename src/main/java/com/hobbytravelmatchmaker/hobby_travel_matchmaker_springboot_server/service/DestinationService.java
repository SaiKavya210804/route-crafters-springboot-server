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

    // Get all destinations
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    // Get destinations by list of interests
    public List<Destination> getDestinationsByInterests(List<String> interests) {
        return destinationRepository.findByInterestsIn(interests);
    }
}
