package com.schooltracker.service;

import java.util.List;

import com.schooltracker.entity.Course;
import com.schooltracker.entity.Student;

public interface StudentService {

	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudent(int theId);

	public void deleteStudent(int theId);
	
	public List<Course> getCourses();
	
	public Student addCourse(int studentId, int courseId);

	public void removeCourse(int studentId, int courseId);

}
