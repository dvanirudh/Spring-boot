package com.example.demo.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;


@EntityScan
@Entity
@Table(name = "student")
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(nullable = false)
        @Size(min = 3, message = "First name must have at least 3 characters")
        private String firstName;

        @Column(nullable = false)
        @Size(min = 3, message = "Last name must have at least 3 characters")
        private String lastName;

        @Column(nullable = false)
        private LocalDate dob;

        private Integer marks1;

        private Integer marks2;

        private Integer marks3;

        private Integer total;

        private Double average;

        private String result;

        @Column(nullable = false)
        @Pattern(regexp = "A|B|C", message = "Section must be A, B, or C")
        private String section;

        @Column(nullable = false)
        @Pattern(regexp = "M|F", message = "Gender must be M or F")
        private String gender;

        public Student() {}

        public Student(int id, String firstName, String lastName, LocalDate dob, Integer marks1, Integer marks2, Integer marks3, Integer total, Double average, String result, String section, String gender) {
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.dob = dob;
                this.marks1 = marks1;
                this.marks2 = marks2;
                this.marks3 = marks3;
                this.total = total;
                this.average = average;
                this.result = result;
                this.section = section;
                this.gender = gender;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public LocalDate getDob() {
                return dob;
        }

        public void setDob(LocalDate dob) {
                this.dob = dob;
        }

        public Integer getMarks1() {
                return marks1;
        }

        public void setMarks1(Integer marks1) {
                this.marks1 = marks1;
        }

        public Integer getMarks2() {
                return marks2;
        }

        public void setMarks2(Integer marks2) {
                this.marks2 = marks2;
        }

        public Integer getMarks3() {
                return marks3;
        }

        public void setMarks3(Integer marks3) {
                this.marks3 = marks3;
        }

        public Integer getTotal() {
                return total;
        }

        public void setTotal(Integer total) {
                this.total = total;
        }

        public Double getAverage() {
                return average;
        }

        public void setAverage(Double average) {
                this.average = average;
        }

        public String getResult() {
                return result;
        }

        public void setResult(String result) {
                this.result = result;
        }

        public String getSection() {
                return section;
        }

        public void setSection(String section) {
                this.section = section;
        }

        public String getGender() {
                return gender;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }
}


