package com.srvnn.StudentCourseRegistrationSystem.controller;

import com.srvnn.StudentCourseRegistrationSystem.models.Course;
import com.srvnn.StudentCourseRegistrationSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("course")
    public String addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @PutMapping("course")
    public String updateCourse(@RequestParam Long courseId, @RequestBody Course updateCourse){
        return courseService.updateCourse(courseId,updateCourse);
    }

    @DeleteMapping("course")
    public String deleteCourse(@RequestParam Long courseId){
        return courseService.deleteCourse(courseId);
    }
}
