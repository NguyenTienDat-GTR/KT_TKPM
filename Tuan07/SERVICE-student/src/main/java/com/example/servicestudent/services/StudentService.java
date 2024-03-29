/*
 * @ (#) StudentService.java   1.0     22/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.servicestudent.services;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   22/03/2024
 *version: 1.0
 */

import com.example.servicestudent.models.Student;
import com.example.servicestudent.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentByID(int id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isEmpty()){
            throw new RuntimeException("Student not found for id: " + id);
        }
        return studentRepository.findById(id).get();
    }

    public Student addStudent(Student student){
        Optional<Student> studentOptional = studentRepository.findById(student.getStudentId());
        if(studentOptional.isPresent()){
            throw new RuntimeException("Student already exists for id: " + student.getStudentId());
        }
        return studentRepository.save(student);
    }

    public Student updateStudent(int id, Student student){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student ExistedStudent = studentOptional.get();
            ExistedStudent.setStudentName(student.getStudentName());
            return studentRepository.save(ExistedStudent);
        }
       else {
           throw new RuntimeException("Student not found for id: " + id);
        }
    }

    public void deleteStudentByID(int id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            studentRepository.delete(studentOptional.get());
        }
        else {
            throw new RuntimeException("Student not found for id: " + id);
        }
    }
}
