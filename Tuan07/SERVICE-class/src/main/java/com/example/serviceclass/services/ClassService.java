/*
 * @ (#) ClassService.java   1.0     22/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.serviceclass.services;

import com.example.serviceclass.models.Student;
import com.example.serviceclass.repositories.ClassStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.serviceclass.models.ClassStudent;
import java.util.List;
import java.util.Optional;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   22/03/2024
 *version: 1.0
 */
@Service
public class ClassService {
    private final ClassStudentRepository classRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public ClassService(ClassStudentRepository classRepository, RestTemplate restTemplate) {
        this.classRepository = classRepository;
        this.restTemplate = restTemplate;
    }

    public List<ClassStudent> getAllClass(){
        return classRepository.findAll();
    }

    public ClassStudent getClassByID(int id) {
        Optional<ClassStudent> classStudentOptional = classRepository.findById(id);
        if (classStudentOptional.isEmpty()) {
            throw new RuntimeException("Class not found for id: " + id);
        } else {
            ClassStudent classStudent = classStudentOptional.get();
            Student student = restTemplate.getForObject("http://localhost:8080/api/v1/student/getStudentByID/" + id, Student.class);
            classStudent.setStudent(student);
            return classStudent;
        }
    }


    public ClassStudent addClass(ClassStudent aClass){
        Optional<ClassStudent> classStudentOptional = classRepository.findById(aClass.getClassID());
        if(classStudentOptional.isPresent()){
            throw new RuntimeException("Class already exists for id: " + aClass.getClassID());
        }
        return classRepository.save(aClass);
    }

    public void deleteClass(int id){
        Optional<ClassStudent> classStudentOptional = classRepository.findById(id);
        if(classStudentOptional.isEmpty()){
            throw new RuntimeException("Class not found for id: " + id);
        }
        classRepository.deleteById(id);
    }

    public ClassStudent updateClass(ClassStudent aClass){
        Optional<ClassStudent> classStudentOptional = classRepository.findById(aClass.getClassID());
        if(classStudentOptional.isEmpty()){
            throw new RuntimeException("Class not found for id: " + aClass.getClassID());
        }else {
            ClassStudent existedClass = classStudentOptional.get();
            existedClass.setClassName(aClass.getClassName());
            existedClass.setStudent(aClass.getStudent());
            return classRepository.save(existedClass);
        }
    }

}
