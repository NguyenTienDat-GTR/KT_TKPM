/*
 * @ (#) DepartmentController.java   1.0     20/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.department.Controllers;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   20/03/2024
 *version: 1.0
 */

import com.example.department.Models.Department;
import com.example.department.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v2/department")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/getDepartment")
    List<Department> getAllDepartment() {
        List<Department> listDepartment = new ArrayList<>();
        return departmentRepository.findAll();
    }

    @PostMapping("/addDepartment")
    Department addDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }
}
