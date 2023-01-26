package com.schooltracker.dao;

import java.util.List;

import com.schooltracker.entity.Course;

public interface CourseDAO {
	
	public List<Course> getCourses();
	
	public void saveCourse(Course saveCourse);
	
	public Course getCourse(int theId);
	
	public void deleteCourse(int theId);

}
