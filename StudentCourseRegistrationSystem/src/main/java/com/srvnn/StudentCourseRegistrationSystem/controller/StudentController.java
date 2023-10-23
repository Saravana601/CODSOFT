package com.srvnn.StudentCourseRegistrationSystem.controller;

import com.srvnn.StudentCourseRegistrationSystem.models.Course;
import com.srvnn.StudentCourseRegistrationSystem.models.Student;
import com.srvnn.StudentCourseRegistrationSystem.service.CourseService;
import com.srvnn.StudentCourseRegistrationSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @GetMapping("courseList")
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("courseById")
    public Course getCourse(@RequestParam Long courseId) {
        return courseService.getCourse(courseId);
    }

    @PostMapping("registerStudent")
    public String registerStudentToCourse(@RequestBody Student student) {
        return studentService.registerStudentToCourse(student);
    }

    @GetMapping("studentsInfo")
    public Student getStudentInfo(@RequestParam Long studentId){
        return studentService.getStudentInfo(studentId);
    }

    @DeleteMapping("dropCourse")
    public String dropCourse(@RequestParam Long studentId, @RequestParam Long courseId) {
        return studentService.dropCourseByCourseId(studentId,courseId);
    }
}
