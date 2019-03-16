package com.website.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.website.springmvc.entities.Student;

@Repository
public class StudentDAO extends DAO<Student> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Student> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> students = session.createQuery("from Student").list();
		return students;
	}

	@Override
	public Student get(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Student) session.get(Student.class, new Long(id));
	}

	@Override
	public Student add(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(student);
		return student;
	}

	@Override
	public Boolean update(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(student);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean delete(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		if (null != student) {
			try {
				session.delete(student);
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
		Student student = (Student) session.load(Student.class, new Long(id));
		if (null != student) {
			session.delete(student);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}