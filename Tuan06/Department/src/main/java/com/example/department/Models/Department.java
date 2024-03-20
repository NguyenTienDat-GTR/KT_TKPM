/*
 * @ (#) Department.java   1.0     20/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.department.Models;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   20/03/2024
 *version: 1.0
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "department")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department {

    @Id
    @Column(name = "department_id")
    private String departmentId;

    @Column(name = "department_name")
    private String departmentName;
}
