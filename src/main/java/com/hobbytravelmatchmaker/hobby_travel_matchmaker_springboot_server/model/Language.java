package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Language {
    private String name;
    private boolean read;
    private boolean write;
    private boolean speak;
}