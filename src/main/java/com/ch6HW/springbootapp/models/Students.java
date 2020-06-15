/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch6HW.springbootapp.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Abu Yasser
 */
@Entity

public class Students {
    
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String major;
    private Double grade;
    
    @JoinTable(
    name = "registration",
            joinColumns = @JoinColumn(name = "studentid"),
            inverseJoinColumns = @JoinColumn(name = "courseid")
    )
    List<Course> courses;

    public Students() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

   

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
    
    
     @Override
    public String toString() {
        return "Students{" + "id=" + id + ", name=" + name + ", major=" + major + ", grade=" + grade + ", courses=" + courses + '}';
    }
}
