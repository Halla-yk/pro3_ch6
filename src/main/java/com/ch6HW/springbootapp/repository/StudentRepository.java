/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch6HW.springbootapp.repository;

import com.ch6HW.springbootapp.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Abu Yasser
 */
public interface StudentRepository extends JpaRepository<Students,Integer>{
    
}
