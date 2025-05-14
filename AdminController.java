package com.example.studentregistration.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.studentregistration.Service.CourseService;
import com.example.studentregistration.modeul.Course;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String manageCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "admin_courses";
    }

    @GetMapping("/addCourse")
    public String addCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "add_course";
    }

    @PostMapping("/addCourse")
    public String addCourse(@ModelAttribute Course course) {
        courseService.saveCourse(course);
        return "redirect:/admin/courses";
    }

    @GetMapping("/editCourse/{id}")
    public String editCourseForm(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "edit_course";
    }

    @PostMapping("/editCourse")
    public String editCourse(@ModelAttribute Course course) {
        courseService.saveCourse(course);
        return "redirect:/admin/courses";
    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/admin/courses";
    }
}
