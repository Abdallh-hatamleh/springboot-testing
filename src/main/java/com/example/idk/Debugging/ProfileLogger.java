package com.example.idk.Debugging;

import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class ProfileLogger {

    private final Environment environment;

    public ProfileLogger(Environment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void logActiveProfile() {
        String activeProfile = environment.getProperty("spring.profiles.active");
        System.out.println("Active profile: " + activeProfile);
    }
}
