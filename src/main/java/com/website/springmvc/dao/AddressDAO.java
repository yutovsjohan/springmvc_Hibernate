package com.website.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.website.springmvc.entity.Address;

@Repository
public class AddressDAO extends DAO<Address> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Address> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Address> address = session.createQuery("from address").list();
		return address;
	}

	@Override
	public Address get(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Address) session.get(Address.class, new Long(id));
	}

	@Override
	public Address add(Address address) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(address);
		return address;
	}

	@Override
	public Boolean update(Address address) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(address);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}
	
	@Override
	public Boolean delete(Address address) {
		Session session = this.sessionFactory.getCurrentSession();
		if(null != address){
			try {
				session.delete(address);
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
		Address address = (Address) session.load(Address.class, new Long(id));
		if(null != address){
			session.delete(address);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

}
