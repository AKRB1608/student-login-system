package com.studentloginsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.studentloginsystem.model.Student;
import com.studentloginsystem.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Student student, Model model) {
        String message = studentService.register(student);
        model.addAttribute("message", message);
        return "register";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("student", new Student());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Student student, Model model) {
        String message = studentService.login(student.getUsername(), student.getPassword());
        model.addAttribute("message", message);

        if (message.equals("Login successful 🎉")) {
            model.addAttribute("username", student.getUsername());
            return "dashboard";
        }
        return "login";
    }
}
