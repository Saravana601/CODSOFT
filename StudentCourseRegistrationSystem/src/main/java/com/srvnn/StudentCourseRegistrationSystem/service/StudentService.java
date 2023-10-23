package com.srvnn.StudentCourseRegistrationSystem.service;

import com.srvnn.StudentCourseRegistrationSystem.models.Course;
import com.srvnn.StudentCourseRegistrationSystem.models.Student;
import com.srvnn.StudentCourseRegistrationSystem.repository.ICourseRepository;
import com.srvnn.StudentCourseRegistrationSystem.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    IStudentRepository iStudentRepository;

    @Autowired
    ICourseRepository iCourseRepository;

    // add student to database
    public String registerStudentToCourse(Student student) {
        iStudentRepository.save(student);
        String courseTitles = getCourseTitle(student.getCourseList());
        return "Successfully Registered to "+ courseTitles + " Your Id is "  + student.getStudentId() + ". Please remember for future use.";
    }

    // This method gets title from Course List
    private String getCourseTitle(List<Course> courseList) {
        return courseList.stream()
                .map(course -> iCourseRepository.findById(course.getCourseId()).orElseThrow().getTitle().toString())
                .collect(Collectors.joining(" ,"));
    }

    // Drop Course by Course I'd
    public String dropCourseByCourseId(Long studentId, Long courseId) {
        Student existingStudent = iStudentRepository.findById(studentId).orElseThrow();
        deleteCourse(existingStudent.getCourseList(),courseId);
        iStudentRepository.save(existingStudent);

        return "Course dropped Successfully";
    }

    // Get Student Info by their I'd
    public Student getStudentInfo(Long studentId) {
        return iStudentRepository.findById(studentId).orElseThrow();
    }

    // Delete course using course I'd
    private void deleteCourse(List<Course> courseList,Long courseId){
        courseList.removeIf(course -> course.getCourseId().equals(courseId));
    }
}
