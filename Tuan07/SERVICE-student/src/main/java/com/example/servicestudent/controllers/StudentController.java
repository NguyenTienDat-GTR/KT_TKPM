/*
 * @ (#) StudentController.java   1.0     22/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.servicestudent.controllers;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   22/03/2024
 *version: 1.0
 */

import com.example.servicestudent.models.Student;
import com.example.servicestudent.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudent")
    List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/getStudentByID/{id}")
    Student getStudentByID(@PathVariable int id) {
        return studentService.getStudentByID(id);
    }

    @PostMapping("/addStudent")
    Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/updateStudent/{id}")
    Student updateStudent(@PathVariable int id ,@RequestBody Student student) {
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping ("/deleteStudentByID/{id}")
    void deleteStudentByID(@PathVariable int id) {
        studentService.deleteStudentByID(id);
    }
}
