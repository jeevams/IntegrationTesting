package com.example.students.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.students.entity.CourseEntity;
import com.example.students.entity.StudentEntity;
import com.example.students.services.CourseServices;
import com.example.students.services.StudentServices;


@RestController
@RequestMapping("/students")
public class CourseController {
	@Autowired
	CourseServices courseServices;

	@Autowired
	StudentServices studentServices;

	// @ResponseStatus(HttpStatus.CREATED)

	@PostMapping("/register/courses")
	public CourseEntity registerCourseDetails( @Valid @RequestBody   CourseEntity  courseEntity) {

		return courseServices.registerCourseDetails(courseEntity);
	}

	@PostMapping("/register/students")
	public StudentEntity registerStudentsDetails( @Valid @RequestBody StudentEntity studentEntity) {

		return 	studentServices.registerStudentsDetails(studentEntity);
	
	}
	

	@PostMapping("/register/TakingCourse")
	public String takingCourse(@RequestParam String stuEmail,@RequestParam String coursename) {
		return courseServices.takingCourse(stuEmail,coursename);

	}

	@GetMapping("/studentNames/{coursename}")
	public List<StudentEntity> studentDetailsByCourses(@PathVariable  String coursename){
		return courseServices.studentDetailsByCourses(coursename);

	}

	@GetMapping("/coursesNames/{studentName}")
	public String CoursesDetailsBystudent(@PathVariable  String studentName){
		return courseServices.CoursesDetailsBystudent(studentName);

	}

	@GetMapping("/coursesNames/exception/{studentId}")
	public StudentEntity StudentDetailsById(@PathVariable  Integer studentId){
		return courseServices.StudentDetailsById(studentId);

	}


}



