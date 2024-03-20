/*
 * @ (#) StudentController.java   1.0     20/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.student.controllers;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   20/03/2024
 *version: 1.0
 */

import com.example.student.Repositories.StudentRepository;
import com.example.student.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/getStudent")
    List<Student> getAllStudent() {
        List<Student> listStudent = new ArrayList<>();

        return studentRepository.findAll();
    }

    @PostMapping("/addStudent")
    Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}
