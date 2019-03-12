package com.website.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.springmvc.dao.DAO;
import com.website.springmvc.entity.Address;

@Transactional
@Service
public class AddressService {
	@Autowired
	DAO<Address> AddressDao;
	
	public List<Address> getAll(){
		return AddressDao.getAll();
	}
	
	public Address get(Long id) {
		return AddressDao.get(id);
	}
	
	public Address add(Address address) throws Exception {
		return AddressDao.add(address);
	}
	
	public Boolean update(Address address) throws Exception {
		return AddressDao.update(address);
	}
	
	public Boolean delete(Address address) throws Exception {
		return AddressDao.delete(address);
	}
	
	public Boolean delete(Long id) throws Exception {
		return AddressDao.delete(id);
	}
}
