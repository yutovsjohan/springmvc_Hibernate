package com.website.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.website.springmvc.entity.Clazz;

@Repository
public class ClazzDAO extends DAO<Clazz> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Clazz> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Clazz> Clazzs = session.createQuery("from clazz").list();
		return Clazzs;
	}

	@Override
	public Clazz get(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Clazz) session.get(Clazz.class, new Long(id));
	}

	@Override
	public Clazz add(Clazz Clazz) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(Clazz);
		return Clazz;
	}

	@Override
	public Boolean update(Clazz Clazz) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(Clazz);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}
	
	@Override
	public Boolean delete(Clazz Clazz) {
		Session session = this.sessionFactory.getCurrentSession();
		if(null != Clazz){
			try {
				session.delete(Clazz);
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
		Clazz Clazz = (Clazz) session.load(Clazz.class, new Long(id));
		if(null != Clazz){
			session.delete(Clazz);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
}
