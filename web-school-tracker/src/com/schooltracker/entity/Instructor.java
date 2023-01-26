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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull(message = "IS REQUIRED")
	@Size(min=1, message = "IS REQUIRED")
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull(message = "IS REQUIRED")
	@Size(min=1, message = "IS REQUIRED")
	@Column(name = "last_name")
	private String lastName;
	
	@Pattern(regexp = "^\\S+@\\S+$", message = "MUST INCLUDE @")
	@Column(name = "email")
	private String email;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "instructor", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, 
			CascadeType.DETACH})
	private List<Course> courses;
	
	public Instructor() {
		
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

	//add convenience methods for bi-directional relationship
	public void addCourse(Course course) {
		if(courses == null) {
			courses  = new ArrayList<>();
		}
		
		courses.add(course);
		
		//bi-directional link
		//course this is your new instructor
		course.setInstructor(this);
	}
	
	
	
	

}
