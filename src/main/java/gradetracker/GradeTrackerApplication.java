package com.gradetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GradeTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GradeTrackerApplication.class, args);
        System.out.println("\n==========================================");
        System.out.println("  Student Grade Tracker is RUNNING!");
        System.out.println("  API:      http://localhost:8080/api");
        System.out.println("  H2 DB:    http://localhost:8080/h2-console");
        System.out.println("==========================================\n");
    }
}
