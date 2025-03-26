package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.validation.constraints.NotNull;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NotNull CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins(
                                "http://localhost:5173",
                                "http://localhost:5174",
                                "https://route-crafters-client-git-299dbe-g-sai-kavya-kalyanis-projects.vercel.app/users"

                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // HTTP methods
                        .allowCredentials(true) // For JWT cookies
                        .allowedHeaders("*"); // Allow all headers
            }
        };
    }
}