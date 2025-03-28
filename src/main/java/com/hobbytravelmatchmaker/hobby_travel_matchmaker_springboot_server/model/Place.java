package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model;

public class Place {
    private String name;
    private String image;
    private String description;

    public Place(String name, String image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}