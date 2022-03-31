package com.example.students.controller;

import com.example.students.entity.StudentEntity;
import com.example.students.services.StudentServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student {

    @Autowired
    StudentServices studentServices;
    
    @GetMapping("/getAll")
    public List<StudentEntity>findAllUsers(){
    	return studentServices.findAllStudents();
    }
    
   
}
