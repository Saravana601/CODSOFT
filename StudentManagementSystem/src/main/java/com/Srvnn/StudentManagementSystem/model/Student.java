package com.Srvnn.StudentManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @NotNull
    private int age;

    @Pattern(regexp = "\\d{10,12}",message = "Please enter valid phone number")
    private String phoneNumber;

    @NotBlank
    private String address;
}