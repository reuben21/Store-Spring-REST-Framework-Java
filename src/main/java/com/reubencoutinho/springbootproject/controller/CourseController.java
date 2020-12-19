package com.reubencoutinho.springbootproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reubencoutinho.springbootproject.model.Course;
import com.reubencoutinho.springbootproject.model.Department;
import com.reubencoutinho.springbootproject.model.Instructor;
import com.reubencoutinho.springbootproject.repository.CourseRepository;
import com.reubencoutinho.springbootproject.repository.DepartmentRepository;
import com.reubencoutinho.springbootproject.repository.InstructorRepository;

@RestController
public class CourseController {
	@Autowired	
	private InstructorRepository instructorRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	//create Instructor
	@PostMapping("/instructor")
	public Instructor addInstructor(@RequestBody Instructor instructor){
		return instructorRepository.save(instructor);
	}
	
	//create Department 
	@PostMapping("/department")
	public Department addDepartment(@RequestBody Department department){
		return departmentRepository.save(department);
	}
	
	//create course : List<instID>: deptID 
	@PostMapping("/course/{departmentId}/{instructorId}")
	public Course createCourse(@RequestBody Course course
			, @PathVariable("departmentId") Long departmentId, 
			  @PathVariable("instructorId") Long instructorId){
		
		//go to DB and fetch department 
		Department department = departmentRepository.getOne(departmentId);
		
		//go to DB and fetch instructor 
		Instructor instructor=  instructorRepository.getOne(instructorId);
		
		//add department to course 
		 course.setDepartment(department);
		 
		//add instructor to course 
		 List<Instructor> list =new ArrayList<>();
		 
		 list.add(instructor);
		 course.setInstructor(list);
		 
		//save course 
		 return courseRepository.save(course);
	}
	
}
