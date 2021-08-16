package com.fis.springlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.springlearn.bean.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
