package com.website.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.springmvc.dao.DAO;
import com.website.springmvc.entity.Course;

@Transactional
@Service
public class CourseService {
	@Autowired
	DAO<Course> CourseDao;
	
	public List<Course> getAll(){
		return CourseDao.getAll();
	}
	
	public Course get(Long id) {
		return CourseDao.get(id);
	}
	
	public Course add(Course Course) throws Exception {
		return CourseDao.add(Course);
	}
	
	public Boolean update(Course Course) throws Exception {
		return CourseDao.update(Course);
	}
	
	public Boolean delete(Course Course) throws Exception {
		return CourseDao.delete(Course);
	}
	
	public Boolean delete(Long id) throws Exception {
		return CourseDao.delete(id);
	}
}
