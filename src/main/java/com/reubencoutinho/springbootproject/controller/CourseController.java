package com.reubencoutinho.springbootproject.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.reubencoutinho.springbootproject.model.*;
import com.reubencoutinho.springbootproject.repository.*;
import javafx.scene.canvas.GraphicsContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	@Autowired	
	private InstructorRepository instructorRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EnrollRepository enrollRepository;
	
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



	//create enroll API for student in course
	@PostMapping("/student/course/{studentId}/{courseId}")
	public Enroll enrollStudentInCourse(@PathVariable("studentId") Long studentId,
										@PathVariable("courseId") Long courseId){
		//3/10
		//fetch student object from studentID
		Student student = studentRepository.getOne(studentId);

		//fetch course object from courseID
		Course course = courseRepository.getOne(courseId);

		//attach student and course to enroll object
		Enroll enroll = new Enroll();
		enroll.setStudent(student);
		enroll.setCourse(course);
		enroll.setDate(LocalDate.now());

		//save enroll object in DB
		return enrollRepository.save(enroll);

	}



}
