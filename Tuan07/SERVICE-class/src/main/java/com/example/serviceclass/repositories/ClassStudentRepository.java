/*
 * @ (#) ClassRepository.java   1.0     22/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */

package com.example.serviceclass.repositories;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   22/03/2024
 *version: 1.0
 */

import com.example.serviceclass.models.ClassStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassStudentRepository extends JpaRepository<ClassStudent, Integer>{
}
