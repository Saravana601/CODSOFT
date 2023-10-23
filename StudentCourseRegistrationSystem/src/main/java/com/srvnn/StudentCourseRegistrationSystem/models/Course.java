package com.srvnn.StudentCourseRegistrationSystem.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.srvnn.StudentCourseRegistrationSystem.models.enums.CourseType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "courseId")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Title must not be null")
    private CourseType title;

    @NotNull
    private String description;

    private Integer capacity;

    private String schedule;

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToMany(mappedBy = "courseList")
    private List<Student> studentList;
}
