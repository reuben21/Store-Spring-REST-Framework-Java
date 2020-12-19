package com.reubencoutinho.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reubencoutinho.springbootproject.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
