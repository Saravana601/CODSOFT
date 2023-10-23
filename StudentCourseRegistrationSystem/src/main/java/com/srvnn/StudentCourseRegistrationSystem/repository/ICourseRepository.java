package com.srvnn.StudentCourseRegistrationSystem.repository;

import com.srvnn.StudentCourseRegistrationSystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course,Long> {
}
