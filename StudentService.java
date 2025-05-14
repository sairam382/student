package com.example.studentregistration.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentregistration.Repository.StudentRepository;
import com.example.studentregistration.modeul.Student;

@Service
public class StudentService {
    @Autowired
    private StudentRepository StudentRepository;

    public Student register(Student student) {
        return StudentRepository.save(student);
    }

    public Optional<Student> findByEmail(String email) {
        return Optional.empty();
    }
}
