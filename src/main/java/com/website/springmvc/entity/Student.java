package com.website.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student", catalog = "website")
public class Student implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "FIRST_NAME", length = 20)	
	private String firstName;
	
	@Column(name = "LAST_NAME", length = 20)
	private String lastName;
	
	@Column(name = "AGE")
	private Integer age;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")
	private Address address;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "STUDENT_COURSE", 
			joinColumns = { @JoinColumn(name = "STUDENT_ID")}, 
			inverseJoinColumns = { @JoinColumn(name = "COURSE_ID")}
			)	
	private List<Course> courses;
	
	@ManyToOne
	@JoinColumn(name="CLAZZ_ID", nullable=false)
	private Clazz clazz;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String firstName, String lastName, Integer age, Address address, Clazz clazz) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.courses = courses;
		this.clazz = clazz;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	public Address getAddress(){
		return address;
	}
	
	public void setAddress(Address address){
		this.address = address;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	
	public String toString() {
		return String.format("{id:%s,firstName:%s,lastName:%s,age:%s,address:%s}", id, firstName, lastName, age,
				address.toString());
	}

	
}
