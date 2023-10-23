package com.srvnn.StudentCourseRegistrationSystem.service;

import com.srvnn.StudentCourseRegistrationSystem.models.Course;
import com.srvnn.StudentCourseRegistrationSystem.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    ICourseRepository iCourseRepository;

    // Add a course to database
    public String addCourse(Course course) {
        iCourseRepository.save(course);
        return "Course Added";
    }

    // Returns list of courses
    public List<Course> getAllCourse() {
        return iCourseRepository.findAll();
    }


    // Delete course by course I'd
    public String deleteCourse(Long courseId) {
        iCourseRepository.deleteById(courseId);
        return "Course deleted successfully";
    }

    // Update Course
    public String updateCourse(Long courseId, Course updateCourse) {
        Course existingCourse = iCourseRepository.findById(courseId).orElseThrow();

        existingCourse.setTitle(updateCourse.getTitle());
        existingCourse.setCapacity(updateCourse.getCapacity());
        existingCourse.setSchedule(updateCourse.getSchedule());
        existingCourse.setDescription(updateCourse.getDescription());
        existingCourse.setStudentList(updateCourse.getStudentList());

        iCourseRepository.save(existingCourse);
        return "Course details updated!";
    }

    // get Course by I'd
    public Course getCourse(Long courseId) {
        return iCourseRepository.findById(courseId).orElseThrow();
    }
}
