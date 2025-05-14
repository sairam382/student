package com.example.studentregistration.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentregistration.modeul.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	List<Registration> findByStudentId(Long studentId);

	Optional<Registration> findByStudentIdAndCourseId(Long studentId, Long courseId);
}
