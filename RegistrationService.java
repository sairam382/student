package com.example.studentregistration.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentregistration.Repository.RegistrationRepository;
import com.example.studentregistration.modeul.Course;
import com.example.studentregistration.modeul.Registration;
import com.example.studentregistration.modeul.Student;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository regRepository;

    public Registration registerCourse(Student student, Course course) {
        Registration reg = new Registration();
        reg.setStudent(student);
        reg.setCourse(course);
        reg.setRegistrationDate(LocalDate.now());
        return regRepository.save(reg);
    }

    public void deregisterCourse(Long studentId, Long courseId) {
        Optional<Registration> reg = regRepository.findByStudentIdAndCourseId(studentId, courseId);
        reg.ifPresent(r -> regRepository.delete(r));
    }

    public List<Registration> getStudentRegistrations(Long studentId) {
        return regRepository.findByStudentId(studentId);
    }
}
