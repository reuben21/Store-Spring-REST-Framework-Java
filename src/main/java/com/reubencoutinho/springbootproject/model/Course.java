package com.reubencoutinho.springbootproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * Course : Department 
 * @OneToOne
 * Course: Instructor 
 * @OneToMany (course_instructor)
 */
@Entity
public class Course {

	@Id //primary key
	@GeneratedValue(strategy=GenerationType.AUTO) //auto incremented
	private Long id; 
	
	private String name; 
	
	private int credits;

	//primary key of department will be added in course table 
	@OneToOne
	private Department department;
	
	@OneToMany
	private List<Instructor> instructor;
	
	 
	
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

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Instructor> getInstructor() {
		return instructor;
	}

	public void setInstructor(List<Instructor> instructor) {
		this.instructor = instructor;
	} 
	
	
}
