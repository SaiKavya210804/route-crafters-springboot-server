package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts") // Maps this entity to the "posts" collection in MongoDB
public class Post {

    @Id
    private String id;
    private String communityId; // ID of the community where the post belongs
    private String userId; // ID of the user who created the post
    private String content; // Post content
    private LocalDateTime createdAt; // Timestamp when the post was created

    // Constructors
    public Post() {}

    public Post(String communityId, String userId, String content) {
        this.communityId = communityId;
        this.userId = userId;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCommunityId() { return communityId; }
    public void setCommunityId(String communityId) { this.communityId = communityId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
