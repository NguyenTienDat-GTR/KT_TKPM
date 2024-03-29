/*
 * @ (#) Enrollment.java   1.0     28/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.serviceenrollment.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   28/03/2024
 *version: 1.0
 */
@Entity
@Table(name = "enrollment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Enrollment {

    @Id
    @Column(name = "enrollment_id", unique = true, nullable = false)
    private int enrollmentId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private ClassStudent classStudent;

    @Column(name = "enrollment_date")
    private LocalDateTime enrollmentDate;

    public Enrollment(int enrollmentId, LocalDateTime enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.enrollmentDate = enrollmentDate;
    }
}
