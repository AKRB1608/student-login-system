package com.studentloginsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.studentloginsystem.model.Student;
import com.studentloginsystem.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Register student
    public String register(Student student) {
        if (studentRepository.findByUsername(student.getUsername()) != null) {
            return "Username already exists ❌";
        }
        if (studentRepository.findByEmail(student.getEmail()) != null) {
            return "Email already exists ❌";
        }
        // Hash password
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepository.save(student);
        return "Registration successful 🎉";
    }

    // Login student
    public String login(String username, String password) {
        Student student = studentRepository.findByUsername(username);
        if (student == null) {
            return "Username not found ❌";
        }
        if (!passwordEncoder.matches(password, student.getPassword())) {
            return "Incorrect password ❌";
        }
        return "Login successful 🎉";
    }
}
