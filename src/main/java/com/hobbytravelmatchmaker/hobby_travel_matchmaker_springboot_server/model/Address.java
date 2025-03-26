package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Address {
    private String currentStreet;
    private String currentCity;
    private String currentState;
    private String currentCountry;
    private String currentPin;

    private String permanentStreet;
    private String permanentCity;
    private String permanentState;
    private String permanentCountry;
    private String permanentPin;

    private boolean sameAsPermanent;
}