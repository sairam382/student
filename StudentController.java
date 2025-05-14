package com.example.studentregistration.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.studentregistration.Service.CourseService;
import com.example.studentregistration.Service.RegistrationService;
import com.example.studentregistration.Service.StudentService;
import com.example.studentregistration.modeul.Course;
import com.example.studentregistration.modeul.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        Student student = studentService.findByEmail(principal.getName()).orElse(null);
        model.addAttribute("student", student);
        model.addAttribute("registrations", registrationService.getStudentRegistrations(student.getId()));
        return "student_dashboard";
    }

    @GetMapping("/courses")
    public String viewCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }

    @PostMapping("/registerCourse")
    public String registerCourse(@RequestParam Long courseId, Principal principal) {
        Student student = studentService.findByEmail(principal.getName()).orElse(null);
        Course course = courseService.getCourseById(courseId);
        registrationService.registerCourse(student, course);
        return "redirect:/student/dashboard";
    }

    @PostMapping("/deregisterCourse")
    public String deregisterCourse(@RequestParam Long courseId, Principal principal) {
        Student student = studentService.findByEmail(principal.getName()).orElse(null);
        registrationService.deregisterCourse(student.getId(), courseId);
        return "redirect:/student/dashboard";
    }
}
