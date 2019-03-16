package com.website.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.springmvc.dao.DAO;
import com.website.springmvc.entities.Student;

@Transactional
@Service
public class StudentService {
	@Autowired
	DAO<Student> studentDao;

	public List<Student> getAll() {
		return studentDao.getAll();
	}

	public Student get(Long id) {
		return studentDao.get(id);
	}

	public Student add(Student student) {
		return studentDao.add(student);
	}

	public Boolean update(Student student) {
		return studentDao.update(student);
	}

	public Boolean delete(Student student) {
		return studentDao.delete(student);
	}

	public Boolean delete(Long id) {
		return studentDao.delete(id);
	}
}
