package com.example.students.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.students.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer>{
	Optional<CourseEntity> findByCoursename(String coursename);

	boolean existsBycoursename(String coursename);

	
}
