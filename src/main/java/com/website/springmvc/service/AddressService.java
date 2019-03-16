package com.website.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.springmvc.dao.DAO;
import com.website.springmvc.entities.Address;

@Transactional
@Service
public class AddressService {
	
	@Autowired
	DAO<Address> addressDAO;
	
	public List<Address> getAll(){
		return addressDAO.getAll();
	}
	
	public Address get(Long id){
		return addressDAO.get(id);
	}
	
	public Address add(Address t){
		return addressDAO.add(t);
	}
	
	public Boolean update(Address t){
		return addressDAO.update(t);
	}
	
	public Boolean delete(Address t){
		return addressDAO.delete(t);
	}
	
	public Boolean delete(Long id){
		return addressDAO.delete(id);
	}
}
