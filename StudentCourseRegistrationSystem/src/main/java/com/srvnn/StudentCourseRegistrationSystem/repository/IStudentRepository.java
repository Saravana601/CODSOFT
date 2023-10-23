package com.srvnn.StudentCourseRegistrationSystem.repository;

import com.srvnn.StudentCourseRegistrationSystem.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {
}
