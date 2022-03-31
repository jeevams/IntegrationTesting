package com.example.students;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.students.entity.CourseEntity;
import com.example.students.entity.StudentEntity;

@SpringBootTest(classes = StudentsApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class IntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate = new TestRestTemplate();

	//courseRegistration	 
	@Test
	public void registerCourseDetails() {

		CourseEntity courseEntity=new CourseEntity("EEE");
		String url="http://localhost:"+port+"/students/register/courses";
		HttpEntity<CourseEntity>entity=new HttpEntity<CourseEntity>(courseEntity,null);
		ResponseEntity<String> repo=restTemplate.exchange(url, HttpMethod.POST,entity,String.class);
		System.out.println("------courseReg---------");
		System.out.println(repo);
	}

	@Test
	public void registerStudentsDetails() {
		StudentEntity studentEntity=new StudentEntity("prakash","praksa@134.gmali.com","9090109141");
		String url="http://localhost:"+port+"/students/register/students";
		HttpEntity<StudentEntity>entity=new HttpEntity<StudentEntity>(studentEntity,null);
		ResponseEntity<String> repo=restTemplate.exchange(url, HttpMethod.POST,entity,String.class);
		System.out.println("------studentReg---------");
		System.out.println(repo);
		System.out.println();
	}

	@Test
	public void takingCourse() {
		String url="http://localhost:"+port+"/students/register/TakingCourse?stuEmail=praksa@134.gmali.com&coursename=EEE";
		HttpEntity<String>entity=new HttpEntity<String>(null,null);
		ResponseEntity<String> repo=restTemplate.exchange(url, HttpMethod.POST,entity,String.class);
		System.out.println("------takingCourse---------");
		System.out.println(repo);
		System.out.println();

	}

	@Test
	public void studentDetailsByCourses() {
		String courseName="EEE";
		String url="http://localhost:"+port+"/students/studentNames/"+courseName;
		HttpEntity<String>entity=new HttpEntity<String>(null,null);
		ResponseEntity<String> repo=restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
		System.out.println("------studentDetailsByCourses---------");

		System.out.println(repo);
		System.out.println();

	}

	@Test
	public void CoursesDetailsBystudent() {
		String stuName="prakash";
		String url="http://localhost:"+port+"/students/coursesNames/"+stuName;
		HttpEntity<String>entity=new HttpEntity<String>(null,null);
		ResponseEntity<String> repo=restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
		System.out.println("------CoursesDetailsBystudent---------");

		System.out.println(repo);
		System.out.println();

	}


	@Test
	public void getStudents() {
		String url="http://localhost:"+port+"/getAll";
		HttpEntity<String>entity=new HttpEntity<String>(null,null);
		ResponseEntity<String> repo=restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
		System.out.println("------getStudents---------");

		System.out.println(repo);
		System.out.println();

	}
	
	@Test
	public void getStudentsById() {
		int stuId=34;
		String url="http://localhost:"+port+"/students/coursesNames/exception/"+stuId;
		HttpEntity<String>entity=new HttpEntity<String>(null,null);
		ResponseEntity<String> repo=restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
		System.out.println("------getStudentsById---------");

		System.out.println(repo);
		System.out.println();

	}


}
