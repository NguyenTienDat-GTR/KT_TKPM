/*
 * @ (#) Class.java   1.0     22/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.serviceclass.models;

import jakarta.persistence.*;
import lombok.*;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   22/03/2024
 *version: 1.0
 */
@Entity
@Table(name = "class")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClassStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id", unique = true, nullable = false)
    private int classID;

    @Column(name = "class_name")
    private String className;

    @OneToOne
    private Student student;

    public ClassStudent(int classID, String className) {
        this.classID = classID;
        this.className = className;
    }

}
