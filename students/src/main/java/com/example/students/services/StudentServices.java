package com.example.students.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.students.entity.StudentEntity;
import com.example.students.repository.StudentRepository;

@Service
public class StudentServices {

	@Autowired
	StudentRepository studentRepository;

	public StudentEntity registerStudentsDetails(StudentEntity studentEntity) {
		return studentRepository.save(studentEntity);

	}
	
	public List<StudentEntity> findAllStudents() {
		return studentRepository.findAll();
	}
	
	
}
