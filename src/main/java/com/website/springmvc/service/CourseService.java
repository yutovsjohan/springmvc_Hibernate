package com.website.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.springmvc.dao.DAO;
import com.website.springmvc.entities.Course;

@Transactional
@Service
public class CourseService {

	@Autowired
	DAO<Course> courseDAO;
	
	public List<Course> getAll(){
		return courseDAO.getAll();
	}
	
	public Course get(Long id){
		return courseDAO.get(id);
	}
	
	public Course add(Course t){
		return courseDAO.add(t);
	}
	
	public Boolean update(Course t){
		return courseDAO.update(t);
	}
	
	public Boolean delete(Course t){
		return courseDAO.delete(t);
	}
	
	public Boolean delete(Long id){
		return courseDAO.delete(id);
	}
}
