package com.example.demo.service;

import com.example.demo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.DemoRepository;

import java.time.LocalDate;
import java.time.Period;

import java.util.List;
import java.util.Optional;

@Service
public class DemoService {

    @Autowired
    private DemoRepository Repository;

    public List<Student> getAllStudents() {

        return Repository.findAll();
    }

    public Student createStudent(Student student) {
        validateAge(student.getDob());
        calculateResults(student);
        return Repository.save(student);
    }

    public Student updateStudentMarks(Long id, Integer marks1, Integer marks2, Integer marks3) {
        Optional<Student> optionalStudent = Repository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setMarks1(marks1);
            student.setMarks2(marks2);
            student.setMarks3(marks3);
            calculateResults(student);
            return Repository.save(student);
        } else {
            throw new RuntimeException("Student not found");
        }
    }

    private void validateAge(LocalDate dob) {
        int age = Period.between(dob, LocalDate.now()).getYears();
        if (age < 15 || age > 20) {
            throw new RuntimeException("Age must be between 15 and 20 years");
        }
    }


    private void calculateResults(Student student) {
        int total = 0;
        int count = 0;

        if (student.getMarks1() != null) {
            total += student.getMarks1();
            count++;
        }
        if (student.getMarks2() != null) {
            total += student.getMarks2();
            count++;
        }
        if (student.getMarks3() != null) {
            total += student.getMarks3();
            count++;
        }

        student.setTotal(total);
        student.setAverage(count > 0 ? (double) total / count : 0.0);
        student.setResult(determineResult(student));
    }

    private String determineResult(Student student) {
        if (student.getMarks1() != null && student.getMarks1() < 35 ||
                student.getMarks2() != null && student.getMarks2() < 35 ||
                student.getMarks3() != null && student.getMarks3() < 35) {
            return "Fail";
        }
        return "Pass";
    }

}
