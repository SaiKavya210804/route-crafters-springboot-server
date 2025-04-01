package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.controller;

import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model.DestinationInsights;
import com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.repository.DestinationInsightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destination-insights")
public class DestinationInsightsController {

    @Autowired
    private DestinationInsightsRepository repository;

    @PostMapping("/add")
    public DestinationInsights addDestinationInsights(@RequestBody DestinationInsights insights) {
        return repository.save(insights);
    }

    @GetMapping("/all")
    public List<DestinationInsights> getAllInsights() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public DestinationInsights getInsightById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public DestinationInsights updateInsights(@PathVariable String id, @RequestBody DestinationInsights newInsights) {
        return repository.findById(id).map(insight -> {
            insight.setDestinationName(newInsights.getDestinationName());
            insight.setBestSeason(newInsights.getBestSeason());
            insight.setLocalExperts(newInsights.getLocalExperts());
            insight.setTips(newInsights.getTips());
            insight.setHighlights(newInsights.getHighlights());
            return repository.save(insight);
        }).orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInsight(@PathVariable String id) {
        repository.deleteById(id);
        return "Deleted successfully!";
    }
}
