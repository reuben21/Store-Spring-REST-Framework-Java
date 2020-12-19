package com.reubencoutinho.springbootproject.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student") //table name: optional 
public class Student {

	@Id //primary key
	@GeneratedValue(strategy=GenerationType.AUTO) //auto incremented
	private Long id; 
	
	private String name; 
	
	@Column(name="student_address") //column name
	private String address; 
	
	@Column(length = 10000)
	private String profile;//max length = 10000
 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
}
