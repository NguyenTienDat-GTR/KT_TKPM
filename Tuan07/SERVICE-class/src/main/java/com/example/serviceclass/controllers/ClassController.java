/*
 * @ (#) ClassController.java   1.0     28/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.serviceclass.controllers;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   28/03/2024
 *version: 1.0
 */

import com.example.serviceclass.models.ClassStudent;
import com.example.serviceclass.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/getAllClass")
    public List<ClassStudent> getAllClass() {
        return classService.getAllClass();
    }

    @GetMapping("/getClassByID/{id}")
    public ClassStudent getClassByID(@PathVariable int id) {
        return classService.getClassByID(id);
    }

    @PostMapping("/addClass")
    public ClassStudent addClass(@RequestBody ClassStudent aClass) {
        return classService.addClass(aClass);
    }

    @DeleteMapping("/deleteClass/{id}")
    public void deleteClass(@PathVariable int id) {
        classService.deleteClass(id);
    }

    @PutMapping("/updateClass/{id}")
    public ClassStudent updateClass(@PathVariable int id, @RequestBody ClassStudent aClass) {
        return classService.updateClass(aClass);
    }
}
