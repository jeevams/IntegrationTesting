package com.example.students.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.students.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	Optional<StudentEntity> findByStuEmail(String stuEmail);

	Optional<StudentEntity> findByStudentName(String studentName);


}
