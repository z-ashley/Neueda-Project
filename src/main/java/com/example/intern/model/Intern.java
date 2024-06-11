package com.example.intern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Intern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String internId;
    private String manager;
    private String mentor;
    private String department;
    private String role;
    private String cycle;
    private String performanceReview;

    // Getters and Setters
    // Add constructors, toString, equals, and hashCode if needed
    
}
