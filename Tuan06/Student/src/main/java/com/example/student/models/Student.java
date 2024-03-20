/*
 * @ (#) Student.java   1.0     20/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.student.models;
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "student_name")
    private String studentName;

}
