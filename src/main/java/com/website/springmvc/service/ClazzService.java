package com.website.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.springmvc.dao.DAO;
import com.website.springmvc.entity.Clazz;

@Transactional
@Service
public class ClazzService {
	@Autowired
	DAO<Clazz> ClazzDao;
	
	public List<Clazz> getAll(){
		return ClazzDao.getAll();
	}
	
	public Clazz get(Long id) {
		return ClazzDao.get(id);
	}
	
	public Clazz add(Clazz Clazz) throws Exception {
		return ClazzDao.add(Clazz);
	}
	
	public Boolean update(Clazz Clazz) throws Exception {
		return ClazzDao.update(Clazz);
	}
	
	public Boolean delete(Clazz Clazz) throws Exception {
		return ClazzDao.delete(Clazz);
	}
	
	public Boolean delete(Long id) throws Exception {
		return ClazzDao.delete(id);
	}
}
