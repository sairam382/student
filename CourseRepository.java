package com.example.studentregistration.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentregistration.modeul.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTitleContainingIgnoreCase(String title);

	com.example.studentregistrationsystem.model.Course save(com.example.studentregistrationsystem.model.Course course);
}
