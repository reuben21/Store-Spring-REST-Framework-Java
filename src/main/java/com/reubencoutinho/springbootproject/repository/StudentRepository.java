package com.reubencoutinho.springbootproject.repository;

import com.reubencoutinho.springbootproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
