package com.schooltracker.dao;

import java.util.List;

import com.schooltracker.entity.Course;
import com.schooltracker.entity.Instructor;

public interface InstructorDAO {
	
	public List<Instructor> getInstructors();
	
	public void saveInstructor(Instructor theInstructor);
	
	public Instructor getInstructor(int theId);
	
	public void deleteInstructor(int theId);
	
	public List<Course> getCourses();
	
	public Instructor addCourse(int instructorId, int courseId);
	
	public void removeCourse(int instructorId, int courseId);


}
