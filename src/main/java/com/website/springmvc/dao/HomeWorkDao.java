package com.website.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.website.springmvc.entities.HomeWork;

@Repository
public class HomeWorkDao extends DAO<HomeWork> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<HomeWork> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from HomeWork").list();
	}

	@Override
	public HomeWork get(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (HomeWork) session.get(HomeWork.class, new Long(id));
	}

	@Override
	public HomeWork add(HomeWork homeWork) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(homeWork);
		return homeWork;
	}

	@Override
	public Boolean update(HomeWork homeWork) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(homeWork);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean delete(HomeWork homeWork) {
		Session session = this.sessionFactory.getCurrentSession();
		if (null != homeWork) {
			try {
				session.delete(homeWork);
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
		HomeWork homeWork = (HomeWork) session.load(HomeWork.class, new Long(id));
		if (null != homeWork) {
			session.delete(homeWork);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}