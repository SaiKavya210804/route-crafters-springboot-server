package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Communities") // Maps to MongoDB collection
public class Community {

    @Id
    private String id;
    private String name;
    private String description;
    private String hobby;
    private List<String> members; // List of user IDs
    private String createdBy; // Creator's user ID
    private LocalDateTime createdAt;

    // Constructors
    public Community() {
    }

    public Community(String name, String description, String hobby, String createdBy) {
        this.name = name;
        this.description = description;
        this.hobby = hobby;
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}