package com.reubencoutinho.springbootproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reubencoutinho.springbootproject.exception.ResourceNotFoundException;
import com.reubencoutinho.springbootproject.model.Student;
import com.reubencoutinho.springbootproject.repository.StudentRepository;

@RestController
public class MainController {

	@Autowired
	private StudentRepository studentRepository;
	
	/*
	 * Get api to fetch all student records
	 */
	@GetMapping("/students")
	public List<Student> getAllStudents(
			@RequestParam(value="page",required=false,defaultValue="0") int page,
			@RequestParam(value="size", required=false,defaultValue="10000") int size){
		//this api should have pagination 
		Pageable pageable = PageRequest.of(page, size); 
		List<Student> list = studentRepository.findAll(pageable).getContent();
		return list;
	}
	
	/*
	 * POST api to insert student record in DB 
	 */
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student){
		/**
		student = {
			"name" : "harry potter",
			"address" : "hogwards",
			"profile" : "Quidich Captain"
			
		}
		*/
		Student s = studentRepository.save(student);
		return s;
	}
	
	/**
	 * PUT api for updating student info 
	 */
	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable("id") Long id,
			@RequestBody Student updatedStudent){
		//first fetch the record of id given
		Student dbStudent = studentRepository.getOne(id); //existing record
		dbStudent.setName(updatedStudent.getName());
		dbStudent.setAddress(updatedStudent.getAddress());
		dbStudent.setProfile(updatedStudent.getProfile());
		
		Student s = studentRepository.save(dbStudent);
		return s;
		
	}
	/*
	 * Delete Student record from DB 
	 */
	@DeleteMapping("/student/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
		Optional<Student> s = studentRepository.findById(id);
		String str = "" + Optional.empty();
		String str1 = "" + s;
		if(str.equals(str1)){
			ResourceNotFoundException res
					= new ResourceNotFoundException("ID Not Found");
			return  new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
		}
		studentRepository.deleteById(id);
		return  new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	@GetMapping("/student")
	public ResponseEntity<?> getSingleStudentRecord(@RequestParam("id") Long id){
		//instead of passing blatant student object, we pass a proper 
		//response entity which allows us to pass status. 
		int id1 = (int) (long)id;
//		 if(id1 == 3){
//			 ResourceNotFoundException res
//			 	= new ResourceNotFoundException("ID Info Not accesible");
//			 return  new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
//		 }
		Optional<Student> s = studentRepository.findById(id);
		String str = "" + Optional.empty();
		 String str1 = "" + s;
		 if(str.equals(str1)){
			 ResourceNotFoundException res 
			 	= new ResourceNotFoundException("ID Not Found");
			 return  new ResponseEntity<>(res, HttpStatus.NOT_FOUND);		 
			 }
		return  new ResponseEntity<>(s, HttpStatus.OK);
	}
}

/**
 * 500: Internal Server Error
 * 404: Not Found 
 * 401: Forbidden 
 * 
 */






