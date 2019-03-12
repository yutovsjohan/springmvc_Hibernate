package com.website.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.website.springmvc.entity.Course;


@Repository
public class CourseDAO extends DAO<Course> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Course> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Course> Courses = session.createQuery("from course").list();
		return Courses;
	}

	@Override
	public Course get(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Course) session.get(Course.class, new Long(id));
	}

	@Override
	public Course add(Course Course) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(Course);
		return Course;
	}

	@Override
	public Boolean update(Course Course) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(Course);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}
	
	@Override
	public Boolean delete(Course Course) {
		Session session = this.sessionFactory.getCurrentSession();
		if(null != Course){
			try {
				session.delete(Course);
				return Boolean.TRUE;
			} catch (Exception e) {
				return Boolean.FALSE;
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean delete(long id){
		Session session = this.sessionFactory.getCurrentSession();
		Course Course = (Course) session.load(Course.class, new Long(id));
		if(null != Course){
			session.delete(Course);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
}

