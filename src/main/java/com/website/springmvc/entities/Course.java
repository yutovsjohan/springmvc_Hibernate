package com.website.springmvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course", catalog = "website")
public class Course implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String courseName;
	private Set<HomeWork> homeworks = new HashSet<HomeWork>();

	public Course() {
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "COURSE_ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "COURSE_NAME", length = 20)
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
	public Set<HomeWork> getHomeworks() {
		return homeworks;
	}

	public void setHomeworks(Set<HomeWork> homeworks) {
		this.homeworks = homeworks;
	}
}