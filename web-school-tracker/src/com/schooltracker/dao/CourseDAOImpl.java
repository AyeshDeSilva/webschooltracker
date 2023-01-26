package com.schooltracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.schooltracker.entity.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Course> getCourses() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Course> theQuery = currentSession.createQuery("from Course", Course.class);

		List<Course> courses = theQuery.getResultList();

		return courses;
	}

	@Override
	public void saveCourse(Course saveCourse) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(saveCourse);

	}

	@Override
	public Course getCourse(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Course course = currentSession.get(Course.class, theId);

		return course;
	}

	@Override
	public void deleteCourse(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from Course where id=:instructorId");

		theQuery.setParameter("instructorId", theId);

		theQuery.executeUpdate();

	}

	
}
