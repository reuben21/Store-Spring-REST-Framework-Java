package com.reubencoutinho.springrest.repository;

import com.reubencoutinho.springrest.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {


}
