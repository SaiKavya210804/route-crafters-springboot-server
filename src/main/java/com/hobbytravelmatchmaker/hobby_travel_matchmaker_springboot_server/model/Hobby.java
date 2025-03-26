package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Hobby {
    private List<String> hobbies;
}