package com.website.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.springmvc.dao.DAO;
import com.website.springmvc.entity.Student;

@Transactional
@Service
public class StudentService {
	@Autowired
	DAO<Student> studentDao;
	
	public List<Student> getAll(){
		return studentDao.getAll();
	}
	
	public Student get(Long id) {
		return studentDao.get(id);
	}
	
	public Student add(Student student) throws Exception {
		return studentDao.add(student);
	}
	
	public Boolean update(Student student) throws Exception {
		return studentDao.update(student);
	}
	
	public Boolean delete(Student student) throws Exception {
		return studentDao.delete(student);
	}
	
	public Boolean delete(Long id) throws Exception {
		return studentDao.delete(id);
	}
}
