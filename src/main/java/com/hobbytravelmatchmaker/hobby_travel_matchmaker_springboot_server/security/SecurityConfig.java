package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth

                        // Endpoints
                        .anyRequest().permitAll() // Secure other endpoints
                )
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for REST APIs
                .httpBasic(Customizer.withDefaults()); // Basic Authentication (Can switch to JWT later)

        return http.build();
    }
}