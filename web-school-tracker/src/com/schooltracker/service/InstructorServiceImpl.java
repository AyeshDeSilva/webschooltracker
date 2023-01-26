package com.schooltracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schooltracker.dao.InstructorDAO;
import com.schooltracker.entity.Course;
import com.schooltracker.entity.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDAO instructorDAO;
	
	@Override
	@Transactional
	public List<Instructor> getInstructors() {

		return instructorDAO.getInstructors();
	}

	@Override
	@Transactional
	public void saveInstructors(Instructor theInstructor) {

		instructorDAO.saveInstructor(theInstructor);
	}

	@Override
	@Transactional
	public Instructor getInstructor(int theId) {

		return instructorDAO.getInstructor(theId);
	}

	@Override
	@Transactional
	public void deleteInstructor(int theId) {

		instructorDAO.deleteInstructor(theId);
	}

	@Override
	@Transactional
	public List<Course> getCourses() {

		return instructorDAO.getCourses();
	}

	@Override
	@Transactional
	public Instructor addCourse(int instructorId, int courseId) {
		
		return instructorDAO.addCourse(instructorId, courseId);
	}

	@Override
	@Transactional
	public void removeCourse(int instructorId, int courseId) {
		
		instructorDAO.removeCourse(instructorId, courseId);
	}

}
