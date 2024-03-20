/*
 * @ (#) DepartmentRepository.java   1.0     20/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.department.Repositories;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   20/03/2024
 *version: 1.0
 */

import com.example.department.Models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
}
