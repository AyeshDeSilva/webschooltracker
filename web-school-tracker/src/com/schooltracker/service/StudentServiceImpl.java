package com.schooltracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schooltracker.dao.StudentDAO;
import com.schooltracker.entity.Course;
import com.schooltracker.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentDAO.getStudent();
	}

	@Override
	@Transactional
	public void saveStudent(Student theStudent) {

		studentDAO.saveStudent(theStudent);
	}

	@Override
	@Transactional
	public Student getStudent(int theId) {
		
		return studentDAO.getStudent(theId);
	}

	@Override
	@Transactional
	public void deleteStudent(int theId) {
		
		studentDAO.deleteStudent(theId);
	}

	@Override
	@Transactional
	public List<Course> getCourses() {
		
		return studentDAO.getCourses();
	}

	@Override
	@Transactional
	public Student addCourse(int studentId, int courseId) {
		
		return studentDAO.addCourse(studentId, courseId);
	}

	@Override
	@Transactional
	public void removeCourse(int studentId, int courseId) {
		
		studentDAO.removeCourse(studentId, courseId);
	}

}
