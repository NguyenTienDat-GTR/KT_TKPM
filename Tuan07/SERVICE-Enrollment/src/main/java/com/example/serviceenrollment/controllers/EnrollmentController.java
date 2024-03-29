/*
 * @ (#) EnrollmentController.java   1.0     28/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.serviceenrollment.controllers;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   28/03/2024
 *version: 1.0
 */

import com.example.serviceenrollment.models.Enrollment;
import com.example.serviceenrollment.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/enrollment")
public class EnrollmentController {

    private EnrollmentService enrollmentService;

    @GetMapping("/getAllEnrollment")
    public List<Enrollment> getAllEnrollment() {
        return enrollmentService.getAllEnrollment();
    }

    @GetMapping("/getEnrollmentByID/{id}")
    public Enrollment getEnrollmentByID(@PathVariable int id) {
        return enrollmentService.getEnrollmentByID(id);
    }

    @PostMapping("/addEnrollment")
    public Enrollment addEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.addEnrollment(enrollment);
    }

    @DeleteMapping("/deleteEnrollment/{id}")
    public void deleteEnrollment(@PathVariable int id) {
        enrollmentService.deleteEnrollment(id);
    }

    @PutMapping("/updateEnrollment/{id}")
    public Enrollment updateEnrollment(@PathVariable int id, @RequestBody Enrollment enrollment) {
        return enrollmentService.updateEnrollment(enrollment);
    }
}
