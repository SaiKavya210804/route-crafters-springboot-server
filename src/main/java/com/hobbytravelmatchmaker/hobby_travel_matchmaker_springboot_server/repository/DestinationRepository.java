package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.repository;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.Destination;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface DestinationRepository extends MongoRepository<Destination, String> {
    List<Destination> findByInterestsIn(List<String> interests);
}
