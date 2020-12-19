package com.reubencoutinho.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reubencoutinho.springbootproject.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
