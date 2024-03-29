/*
 * @ (#) ClassStudent.java   1.0     28/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.serviceenrollment.models;

import jakarta.persistence.*;
import lombok.*;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   28/03/2024
 *version: 1.0
 */
@Entity
@Table(name = "class")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClassStudent {

    @Id
    @Column(name = "class_id")
    private int classID;

    @Column(name = "class_name")
    private String className;

}
