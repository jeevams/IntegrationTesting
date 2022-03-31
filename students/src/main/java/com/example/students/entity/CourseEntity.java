package com.example.students.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "courses")
public class CourseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "couseid")
	private Integer courseid;
	@Column(name = "coursename", nullable = false, unique = true)
	@NotBlank(message = "courseName is mandatory")
	private String coursename;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "courseEntity")

	private List<StudentEntity>stu;

	public CourseEntity() {
		
	}
public CourseEntity(Integer courseid, @NotBlank(message = "courseName is mandatory") String coursename) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
	}
	
	public CourseEntity(Integer courseid, @NotBlank(message = "courseName is mandatory") String coursename,
			List<StudentEntity> stu) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.stu = stu;
	}

	public CourseEntity(String coursename) {
		this.coursename=coursename;		
	}
	public List<StudentEntity> getStu() {
		return stu;
	}
	@Override
	public String toString() {
		return "CourseEntity [courseid=" + courseid + ", coursename=" + coursename + ", stu=" + stu + "]";
	}
	public void setStu(List<StudentEntity> stu) {
		this.stu = stu;
	}
	public Integer getCourseid() {
		return courseid;
	}
	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}


}

