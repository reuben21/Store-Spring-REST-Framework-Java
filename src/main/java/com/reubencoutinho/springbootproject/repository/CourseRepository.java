package com.reubencoutinho.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reubencoutinho.springbootproject.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
