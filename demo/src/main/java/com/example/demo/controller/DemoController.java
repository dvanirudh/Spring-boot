package com.example.demo.controller;

import com.example.demo.Entity.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.DemoService;

import java.util.List;


@RestController
public class DemoController {
    @Autowired
    private DemoService Service;
    
    @GetMapping("getStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = Service.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        try {
            Student savedStudent = Service.createStudent(student);
            return ResponseEntity.ok(savedStudent);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}/marks")
    public ResponseEntity<Student> updateStudentMarks(@PathVariable Long id, @RequestParam Integer marks1,
                                                      @RequestParam Integer marks2, @RequestParam Integer marks3) {
        try {
            Student updatedStudent = Service.updateStudentMarks(id, marks1, marks2, marks3);
            return ResponseEntity.ok(updatedStudent);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
