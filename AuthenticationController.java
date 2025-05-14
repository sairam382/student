package com.example.studentregistration.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.studentregistration.Service.StudentService;
import com.example.studentregistration.modeul.Student;

@Controller
public class AuthenticationController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Student student) {
        studentService.register(student);
        return "redirect:/login";
    }
}

