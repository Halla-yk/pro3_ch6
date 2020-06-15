/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch6HW.springbootapp.repository;

import com.ch6HW.springbootapp.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Abu Yasser
 */
public interface CourseRepository extends JpaRepository<Course,Integer>{
    
}
