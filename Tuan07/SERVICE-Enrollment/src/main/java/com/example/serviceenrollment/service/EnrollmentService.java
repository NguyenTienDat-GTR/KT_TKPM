/*
 * @ (#) EnrollmentService.java   1.0     28/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.serviceenrollment.service;

import com.example.serviceenrollment.models.ClassStudent;
import com.example.serviceenrollment.models.Enrollment;
import com.example.serviceenrollment.models.Student;
import com.example.serviceenrollment.repositories.EnrollmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   28/03/2024
 *version: 1.0
 */
@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    private final RestTemplate restTemplate;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, RestTemplate restTemplate) {
        this.enrollmentRepository = enrollmentRepository;
        this.restTemplate = restTemplate;
    }

    public Enrollment addEnrollment(Enrollment enrollment) {
        Student student = restTemplate.getForObject("http://localhost:8080/api/v1/student/getStudentByID/" + enrollment.getStudent().getStudentId(), Student.class);
        ClassStudent aClass = restTemplate.getForObject("http://localhost:8081/api/v2/class/getClassByID/" + enrollment.getClassStudent().getClassID(), ClassStudent.class);
        enrollment.setStudent(student);
        enrollment.setClassStudent(aClass);
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getAllEnrollment() {
        return enrollmentRepository.findAll();
    }

    public Enrollment getEnrollmentByID(int id) {
        Optional<Enrollment> enrollmentOptional = enrollmentRepository.findById(id);
        if (enrollmentOptional.isEmpty()) {
            throw new RuntimeException("Enrollment not found for id: " + id);
        } else {
            Student student = restTemplate.getForObject("http://localhost:8080/api/v1/student/getStudentByID/" + id, Student.class);
            ClassStudent aClass = restTemplate.getForObject("http://localhost:8081/api/v2/class/getClassByID/" + id, ClassStudent.class);
            Enrollment enrollment = enrollmentOptional.get();
            enrollment.setClassStudent(aClass);
            enrollment.setStudent(student);
            return enrollment;
        }
    }

    public void deleteEnrollment(int id) {
        Optional<Enrollment> enrollmentOptional = enrollmentRepository.findById(id);
        if (enrollmentOptional.isEmpty()) {
            throw new RuntimeException("Enrollment not found for id: " + id);
        }
        enrollmentRepository.deleteById(id);
    }

    public Enrollment updateEnrollment(Enrollment enrollment) {
        Optional<Enrollment> enrollmentOptional = enrollmentRepository.findById(enrollment.getEnrollmentId());
        if (enrollmentOptional.isEmpty()) {
            throw new RuntimeException("Enrollment not found for id: " + enrollment.getEnrollmentId());
        }else {
            Enrollment existedEnrollment = enrollmentOptional.get();
//            Student student = restTemplate.getForObject("http://localhost:8080/api/v1/student/getStudentByID/" + enrollment.getStudent().getStudentId(), Student.class);
//            ClassStudent aClass = restTemplate.getForObject("http://localhost:8081/api/v2/class/getClassByID/" + enrollment.getClassStudent().getClassID(), ClassStudent.class);
            existedEnrollment.setStudent(enrollment.getStudent());
            existedEnrollment.setClassStudent(enrollment.getClassStudent());
            return enrollmentRepository.save(existedEnrollment);
        }
    }
}
