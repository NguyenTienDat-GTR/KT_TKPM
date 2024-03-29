/*
 * @ (#) EnrollmentRepository.java   1.0     28/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */

package com.example.serviceenrollment.repositories;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   28/03/2024
 *version: 1.0
 */

import com.example.serviceenrollment.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer>{
}
