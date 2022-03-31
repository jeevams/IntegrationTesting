package com.example.students.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "student")

public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stuid")
	private Integer stuId;
	@Column(name = "stuname", nullable = false)
	//@NotNull(message = "StudentName must have at least 2 characters") 
	@NotBlank(message = "StudentName is mandatory")
	private String studentName;
	@Email(message = "Email should be valid")
	@Column(name = "stumail", nullable = false, unique = true)
	private String stuEmail;

	@Column(name = "phonenumber", nullable = false, unique = true)
	@Size(min=0,max=10,message = "Phone number shouble be length 10	")
	private String phoneNumber;

	@ManyToOne
	@JoinColumn(name="course_id")
	CourseEntity courseEntity;
	public CourseEntity getCourseEntity() {
		return courseEntity;
	}
	
	
	public StudentEntity() {
		
	}


	public StudentEntity(Integer stuId, @NotBlank(message = "StudentName is mandatory") String studentName,
			@Email(message = "Email should be valid") String stuEmail,
			@Size(min = 0, max = 10, message = "Phone number shouble be length 10\t") String phoneNumber,
			CourseEntity courseEntity) {
		super();
		this.stuId = stuId;
		this.studentName = studentName;
		this.stuEmail = stuEmail;
		this.phoneNumber = phoneNumber;
		this.courseEntity = courseEntity;
	}





	public StudentEntity(Integer stuId, @NotBlank(message = "StudentName is mandatory") String studentName,
			@Email(message = "Email should be valid") String stuEmail,
			@Size(min = 0, max = 10, message = "Phone number shouble be length 10\t") String phoneNumber) {
		super();
		this.stuId = stuId;
		this.studentName = studentName;
		this.stuEmail = stuEmail;
		this.phoneNumber = phoneNumber;
	}

	public StudentEntity(String studentName, String stuEmail, String phoneNumber) {
		this.studentName = studentName;
		this.stuEmail = stuEmail;
		this.phoneNumber = phoneNumber;
	}


	public void setCourseEntity(CourseEntity courseEntity) {
		this.courseEntity = courseEntity;
	}
	@Override
	public String toString() {
		return "StudentEntity [stuId=" + stuId + ", studentName=" + studentName + ", stuEmail=" + stuEmail
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}


}