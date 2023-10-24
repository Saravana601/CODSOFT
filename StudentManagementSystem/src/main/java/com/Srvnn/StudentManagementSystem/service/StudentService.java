package com.Srvnn.StudentManagementSystem.service;

import com.Srvnn.StudentManagementSystem.model.Student;
import com.Srvnn.StudentManagementSystem.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    IStudentRepository iStudentRepository;

    // add student to database
    public String addStudent(Student student) {
        iStudentRepository.save(student);
        return "Student added. Your id is " + student.getStudentId() + ". Please remember for future use.";
    }

    // get student by their I'd
    public Student getStudentById(Long studentId) {
        return iStudentRepository.findById(studentId).orElseThrow();
    }

    // get all students
    public List<Student> getAllStudents() {
        return iStudentRepository.findAll();
    }

    // update student info
    public String updateStudentById(Long studentId, Student updatedStudent) {
        // getting existing student from database using student i'd
        Student existingStudent = getStudentById(studentId);

        // setting updated students data to existing student's data
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setGrade(updatedStudent.getGrade());
        existingStudent.setPhoneNumber(updatedStudent.getPhoneNumber());
        existingStudent.setAddress(updatedStudent.getAddress());

        // saves the updated student to database
        iStudentRepository.save(existingStudent);

        return "Student updated successfully";
    }

    // delete student by student I'd
    public String deleteStudentById(Long studentId) {
        iStudentRepository.deleteById(studentId);
        return "Student deleted successfully";
    }
}
