package com.example.students;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.students.entity.CourseEntity;
import com.example.students.entity.StudentEntity;
import com.example.students.services.CourseServices;
import com.example.students.services.StudentServices;

@SpringBootTest
@RunWith(SpringRunner.class)
class StudentsApplicationTests {
	@Test
	void contextLoads() {
	}





	@MockBean
	private StudentServices studentServices;
	@MockBean
	private CourseServices courseServices;




	//couserRegister

	@Test
	void registerCourseDetails()throws Exception{
		CourseEntity courseEntity = new CourseEntity(1, "ECE");
		
		when(courseServices.registerCourseDetails(courseEntity)).thenReturn(courseEntity);
		
		CourseEntity expected = courseServices.registerCourseDetails(courseEntity);
		
		assertEquals(expected,courseEntity);
	}

	//registerSudentsDetails
	@Test 
	void registerStudentsDetails()throws Exception{
		StudentEntity studentEntity=new StudentEntity(3, "jeeva@gmail.com","jeeva","8220279972");
		
		when(studentServices.registerStudentsDetails(studentEntity)).thenReturn(studentEntity);
		
		StudentEntity expected = studentServices.registerStudentsDetails(studentEntity);
		
		System.out.println("studentsRegister");
		
		System.out.println(expected);
		
		assertEquals(expected,studentEntity);

	}

	//takingCourse
	@Test
	void takingCourse()throws Exception{

		String email="jeevams47@gmail.com";
		String courseName="IT";
		when(courseServices.takingCourse(email,courseName)).thenReturn("Success");
		String expected = courseServices.takingCourse(email,courseName);
		assertEquals(expected,"Success");
	}


	//studentDetailsByCourseName
	@Test
	void studentDetailsByCourses()throws Exception{

		List<StudentEntity>stu=new ArrayList<>();
		stu.add(new StudentEntity(1, "jeeva@gmail.com","jeeva","8220279972"));
		stu.add(new StudentEntity(2, "sakthi@gamil.com","sakthi","9095109241"));
		stu.add(new StudentEntity(3, "prakash@gmail.com","prakash","9122334341"));
		String courseName="IT";
		when(courseServices.studentDetailsByCourses(courseName)).thenReturn(stu);
		List<StudentEntity> expected = courseServices.studentDetailsByCourses(courseName);
		System.out.println(expected);
		assertEquals(expected,stu);
	}

	//CoursesDetailsBystudent
	@Test
	void CoursesDetailsBystudent()throws Exception{


		String courseName="IT";
		String studentName="jeeva MS";
		when(courseServices.CoursesDetailsBystudent(studentName)).thenReturn(courseName);
		String expected = courseServices.CoursesDetailsBystudent(studentName);
		System.out.println(expected);
		assertEquals(expected,courseName);
	}


	/*@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {

		System.out.println("beforeEach");
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}*/


	
	
	
	
	
	
	
	/*@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	private List<StudentEntity> stuList;
	private List<CourseEntity>courseEntities;
	private int stuId;
	private CourseEntity courseEntity;

	@BeforeEach
	public void setUp() {

		System.out.println("beforeEach");
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		this.stuList = new ArrayList<>();
		this.stuList.add(new StudentEntity(1, "user1@gmail.com", "user1","8220279972"));
		this.stuList.add(new StudentEntity(2, "user2@gmail.com", "user2","9095109241"));
		this.stuId=3;

		this.courseEntities = new ArrayList<>();
		this.courseEntities.add(new CourseEntity(1, "ECE"));
		this.courseEntities.add(new CourseEntity(2, "IT"));

		this.courseEntity=new CourseEntity(1, "ECE");


	}
	 */


	//findAllUsers
	/*@Test
	void shouldFetchAllStudents() throws Exception {


		Mockito.when(studentServices.findAllStudents()).thenReturn(stuList);
		List<StudentEntity>expected=studentServices.findAllStudents();
		assertEquals(expected, stuList);

	}

	//findById
	@Test
	void findById() throws Exception {


		StudentEntity studentEntity=new StudentEntity(3, "jeeva@gmail.com","jeeva","8220279972");
		Mockito.when(studentServices.findById(stuId)).thenReturn(Optional.of(studentEntity));

		this.mockMvc.perform(get("/size/{stuId}", stuId))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.studentName", is(studentEntity.getStudentName())))
		.andExpect(jsonPath("$.stuId", is(stuId)))
		.andExpect(jsonPath("$.stuEmail", is(studentEntity.getStuEmail())));
	}*/

	//registerCourseDetails



}
