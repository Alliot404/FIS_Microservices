package com.fis.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.ormlearn.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
