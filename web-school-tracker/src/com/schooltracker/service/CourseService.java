package com.schooltracker.service;

import java.util.List;

import com.schooltracker.entity.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	
	public void saveCourse(Course theCourse);
	
	public Course getCourse(int theId);
	
	public void deleteCourse(int theId);
	
}
