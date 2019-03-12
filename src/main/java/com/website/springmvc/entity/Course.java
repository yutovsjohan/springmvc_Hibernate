package com.website.springmvc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course", catalog = "website")
public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COURSE_ID", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "COURSE_NAME", length = 100)
	private String courseName;


	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String toString() {
		return String.format("{id: %s, name: %s}", id, courseName);
	}
	
}
