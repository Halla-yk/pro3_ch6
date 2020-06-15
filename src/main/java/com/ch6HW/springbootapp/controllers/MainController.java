/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch6HW.springbootapp.controllers;

import com.ch6HW.springbootapp.models.Students;
import com.ch6HW.springbootapp.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
//    @Autowired
//     StudentRepository studentRepository;
    @RequestMapping("/")
    public String Index(){
    return String.format("%s", "hello world");
    }
//     
//    @RequestMapping("/showall")
//    public String showAll(){
//    List<Students> students = studentRepository.findAll(); 
//    String str = "";
//    for(Students s : students)
//    str = s +"<br>";
//    return String.format("%s", str);
//    
//    
//    }
}
