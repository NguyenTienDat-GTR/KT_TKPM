/*
 * @ (#) Student.java   1.0     22/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.serviceclass.models;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   22/03/2024
 *version: 1.0
 */

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", unique = true, nullable = false)
    private int studentId;

    @Column(name = "student_name")
    private String studentName;
}
