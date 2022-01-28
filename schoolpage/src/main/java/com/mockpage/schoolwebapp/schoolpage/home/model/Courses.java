package com.mockpage.schoolwebapp.schoolpage.home.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String course_name;
	private int course_duration;
	private Long department_id;
	private String department_name;
	private String tutors;
	@Lob
	private String resources;

	protected Courses() {}
	
	public Courses(String course_name, int course_duration, Long department_id, String department_name,
			String tutors, String resources) {
		super();
		this.course_name = course_name;
		this.course_duration = course_duration;
		this.department_id = department_id;
		this.department_name = department_name;
		this.tutors = tutors;
		this.resources = resources;
	}
	public Long getId() {
		return id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public int getCourse_duration() {
		return course_duration;
	}
	public Long getDepartment_id() {
		return department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public String getTutors() {
		return tutors;
	}
	public String getResources() {
		return resources;
	}
	@Override
	public String toString() {
		return "Courses [id=" + id + ", course_name=" + course_name + ", course_duration=" + course_duration
				+ ", department_id=" + department_id + ", department_name=" + department_name + ", tutors=" + tutors
				+ ", resources=" + resources + "]";
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public void setCourse_duration(int course_duration) {
		this.course_duration = course_duration;
	}
	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public void setTutors(String tutors) {
		this.tutors = tutors;
	}
	public void setResources(String resources) {
		this.resources = resources;
	}
	
	
}
