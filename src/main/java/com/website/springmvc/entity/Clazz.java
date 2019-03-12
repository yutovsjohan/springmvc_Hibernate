package com.website.springmvc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clazz", catalog="website")
public class Clazz implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "NAME", length = 100, nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clazz", cascade=CascadeType.ALL)
	private List<Student> students;

	public Clazz() {
		
	}

	public Clazz(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}	

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String toString() {
		return String.format("{id: %s, name: %s}", id, name);
	}
}
