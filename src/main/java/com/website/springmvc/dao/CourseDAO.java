package com.website.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.website.springmvc.entities.Course;

@Repository
public class CourseDAO extends DAO<Course> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Course> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Course").list();
	}

	@Override
	public Course get(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Course) session.get(Course.class, new Long(id));
	}

	@Override
	public Course add(Course course) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(course);
		return course;
	}

	@Override
	public Boolean update(Course course) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(course);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean delete(Course course) {
		Session session = this.sessionFactory.getCurrentSession();
		if (null != course) {
			try {
				session.delete(course);
				return Boolean.TRUE;
			} catch (Exception e) {
				return Boolean.FALSE;
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean delete(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Course course = (Course) session.load(Course.class, new Long(id));
		if (null != course) {
			session.delete(course);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}