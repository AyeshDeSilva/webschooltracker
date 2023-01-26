package com.schooltracker.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@NotNull(message = "IS REQUIRED")
	@Size(min=1, message = "IS REQUIRED")
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message = "IS REQUIRED")
	@Size(min=1, message = "IS REQUIRED")
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	@Pattern(regexp = "^\\S+@\\S+$", message = "MUST INCLUDE @")
	private String email;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(
			name = "course_student", 
			joinColumns = @JoinColumn(name = "student_id"), 
			inverseJoinColumns = @JoinColumn(name = "course_id")
			)
	private List<Course> courses;

	public Student() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course course) {
		
		if(courses == null) {
			courses = new ArrayList<>();
		}
		
		courses.add(course);
		
	}
	



}
