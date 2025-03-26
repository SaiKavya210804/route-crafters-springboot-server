package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users") // MongoDB collection name
public class User {

    @Id
    private String id; // MongoDB automatically generates ObjectId

    private Personal personal; // Personal details (name, email, phone, dob, gender)
    private Address address; // Address details (permanent, current, sameAsPermanent)
    private List<Language> languages; // List of languages (name, read, write, speak)
    private List<String> hobbies; // List of hobbies (Strings)
    private Credentials credentials; // Username, password, confirmPassword
    private String role; // consumer, seller, admin

}
