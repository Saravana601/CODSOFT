package com.Srvnn.StudentManagementSystem.controller;

import com.Srvnn.StudentManagementSystem.model.Student;
import com.Srvnn.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public String addStudent(Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/{studentId}")
    public String updateStudentById(@PathVariable Long studentId, @RequestBody Student updatedStudent) {
        return studentService.updateStudentById(studentId,updatedStudent);
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudentById(@PathVariable Long studentId) {
        return studentService.deleteStudentById(studentId);
    }
}