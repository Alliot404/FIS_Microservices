package com.fis.springlearn.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fis.springlearn.bean.Department;
import com.fis.springlearn.dao.DepartmentDao;
import com.fis.springlearn.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Transactional
	public Department findDepartmentById(int id) {
		return departmentRepository.findById(id).get();
	}

	@Autowired
	private DepartmentDao departmentDao;

	public ArrayList<Department> getAllDepartments() {
		return departmentDao.getAllDepartments();
	}

}
