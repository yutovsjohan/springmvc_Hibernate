package com.website.springmvc.dao;

import java.util.List;

import com.website.springmvc.entity.Student;

public abstract class DAO<T> {
	
	public abstract List<T> getAll();	
	public abstract T get(long id);
	public abstract T add(T t) throws Exception;
	public abstract Boolean update(T t) throws Exception;
	public abstract Boolean delete(long id) throws Exception;
	public abstract Boolean delete(T t);
}
