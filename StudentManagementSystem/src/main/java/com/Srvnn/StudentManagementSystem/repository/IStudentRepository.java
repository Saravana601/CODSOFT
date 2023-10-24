package com.Srvnn.StudentManagementSystem.repository;

import com.Srvnn.StudentManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {
}
