package com.reubencoutinho.springbootproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 *  Instructor : Course 
 *
 */
@Entity
public class Instructor {
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.AUTO) //auto incremented
	private Long id; 
	
	private String name;
	
	private double salary;

	
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	} 
	
	
}
