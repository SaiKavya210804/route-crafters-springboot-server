package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "destination_insights")
public class DestinationInsights {

    @Id
    private String id;
    private String destinationName;
    private String bestSeason;
    private List<String> localExperts;
    private List<String> tips; // Changed from String to List<String>
    private String highlights;
    private List<String> hiddenGems;

    // Constructors
    public DestinationInsights() {
    }

    public DestinationInsights(String destinationName, String bestSeason, List<String> localExperts, List<String> tips,
            String highlights, List<String> hiddenGems) { // Added hiddenGems
        this.destinationName = destinationName;
        this.bestSeason = bestSeason;
        this.localExperts = localExperts;
        this.tips = tips;
        this.highlights = highlights;
        this.hiddenGems = hiddenGems;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getBestSeason() {
        return bestSeason;
    }

    public void setBestSeason(String bestSeason) {
        this.bestSeason = bestSeason;
    }

    public List<String> getLocalExperts() {
        return localExperts;
    }

    public void setLocalExperts(List<String> localExperts) {
        this.localExperts = localExperts;
    }

    public List<String> getTips() { // Changed to return List<String>
        return tips;
    }

    public void setTips(List<String> tips) { // Changed parameter type
        this.tips = tips;
    }

    public String getHighlights() {
        return highlights;
    }

    public void setHighlights(String highlights) {
        this.highlights = highlights;
    }

    public List<String> getHiddenGems() {
        return hiddenGems;
    }

    public void setHiddenGems(List<String> hiddenGems) {
        this.hiddenGems = hiddenGems;
    }
}
