package com.example.studentmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotBlank(message = "Name is required")
    private String name;

    @Min(5)
    @Max(100)
    private int age;

    @NotBlank(message = "Class is required")
    private String studentClass;

    @Email
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    // Getters and setters
}
