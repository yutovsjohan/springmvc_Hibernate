package com.website.springmvc.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address", catalog = "website")
public class Address implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private long id;
	
	@Column(name = "street", length = 100)
	private String street;
	
	@Column(name = "district", length = 100)
	private String district;
	
	@Column(name = "city", length = 100)
	private String city;
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String district, String city) {
		super();
		this.street = street;
		this.district = district;
		this.city = city;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String toString(){
		return String.format("{id:%s,street:%s,district:%s,city:%s}", id, street, district, city);
	}
	
}
