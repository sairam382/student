package com.example.studentregistration.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentregistration.Repository.CourseRepository;
import com.example.studentregistration.modeul.Course;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
    	courseRepository.deleteById(id);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> searchCourses(String keyword) {
        return courseRepository.findByTitleContainingIgnoreCase(keyword);
    }
}
