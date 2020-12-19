package com.reubencoutinho.springbootproject.model;

import java.time.LocalDate;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Enroll {
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.AUTO) //auto incremented
	private Long id; 
	
	@ManyToOne
	private Course course; 
	
	@ManyToOne
	private Student student; 
	
	private LocalDate date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	} 
	
	
	
}
