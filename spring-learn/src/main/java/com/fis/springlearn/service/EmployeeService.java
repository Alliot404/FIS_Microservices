package com.fis.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fis.springlearn.bean.Employee;
import com.fis.springlearn.repository.EmployeeRepository;

//@Component
@Service
public class EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Transactional
	public Employee get(int id) {
		LOGGER.info("Start");
		return employeeRepository.findById(id).get();
	}

	@Transactional
	public void save(Employee employee) {
		LOGGER.info("Start");
		employeeRepository.save(employee);
		LOGGER.info("End");
	}

	@Transactional
	public List<Employee> getAllPermanentEmployees() {
		LOGGER.info("Start");
		return employeeRepository.getAllPermanentEmployees();
	}

	@Transactional
	public double getAverageSalary() {
		return employeeRepository.getAverageSalary();
	}

	@Transactional
	public double getAverageSalary(int id) {
		return employeeRepository.getAverageSalary(id);
	}

	@Transactional
	public List<Employee> getAllEmployeesNative() {
		return employeeRepository.getAllEmployeesNative();
	}
//	private EmployeeDao employeeDao;
//
//	@Autowired
//	public void setEmployeeDao(EmployeeDao employeeDao) {
//		SpringLearnConstants.LOGGER.debug("Inside EmployeeService Constructor");
//		this.employeeDao = employeeDao;
//	}
//
//	public List<Employee> getAllEmployees() {
//		return employeeDao.getAllEmployees();
//	}
//
//	public Employee getEmployee(int id) throws EmployeeNotFoundException {
//		return employeeDao.getEmployee(id);
//	}
//	
//	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
//		employeeDao.updateEmployee(employee);
//	}
}
