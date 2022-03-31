package com.example.students.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.students.entity.CourseEntity;
import com.example.students.entity.StudentEntity;
import com.example.students.exception.ExistsByCourseName;
import com.example.students.exception.StudentsIdNotFound;
import com.example.students.repository.CourseRepository;
import com.example.students.repository.StudentRepository;

@Service
public class CourseServices {

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	StudentRepository studentRepository;

	public CourseEntity registerCourseDetails(CourseEntity courseEntity)throws ExistsByCourseName{
		System.out.println("registerCourseDetails");

		String coursename=courseEntity.getCoursename();

		System.out.println("registerCourseDetails");

		if(courseRepository.existsBycoursename(coursename)) {
			throw new ExistsByCourseName();
		}

		else {
			return courseRepository.save(courseEntity);
		//	return "Insert Successfully";
		}
	}


	public String takingCourse(String stuEmail, String coursename) {
		Optional<CourseEntity>couOp=courseRepository.findByCoursename(coursename);
		Optional<StudentEntity>stuOp=studentRepository.findByStuEmail(stuEmail);

		if(couOp.isPresent() && stuOp.isPresent()) {

			CourseEntity courseEntity=couOp.get();//course information.
			StudentEntity studentEntity=stuOp.get();//student information.
			List<StudentEntity>stuList=courseEntity.getStu();
			stuList.add(studentEntity);
			courseEntity.setStu(stuList);
			studentRepository.save(studentEntity);
			studentEntity.setCourseEntity(courseEntity);
			courseRepository.save(courseEntity);
			return "Success"; 
		}
		return "failed";


	}


	public List<StudentEntity> studentDetailsByCourses(String coursename) {

		Optional<CourseEntity>couOp=courseRepository.findByCoursename(coursename);
		if(couOp.isPresent()) {
			return couOp.get().getStu();
		}
		return null;
	}


	public String CoursesDetailsBystudent(String studentName) {

		Optional<StudentEntity>stuOp=studentRepository.findByStudentName(studentName);
		if(stuOp.isPresent()) {

			String name=stuOp.get().getCourseEntity().getCoursename();
			return name;
		}

		return null ;
	}


	public StudentEntity StudentDetailsById(Integer studentId) throws StudentsIdNotFound{
		if(studentRepository.existsById(studentId)) {
			return studentRepository.findById(studentId).get();
		}
		throw new StudentsIdNotFound();
	}
}
