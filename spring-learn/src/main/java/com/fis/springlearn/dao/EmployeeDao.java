package com.fis.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.fis.springlearn.SpringLearnConstants;
import com.fis.springlearn.bean.Employee;
import com.fis.springlearn.service.exception.EmployeeNotFoundException;

//@Component
public class EmployeeDao {
	static ArrayList<Employee> EMPLOYEE_LIST;

	public EmployeeDao() {
		SpringLearnConstants.LOGGER.debug("Inside EmployeeDao Constructor");
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = context.getBean("employeeList", ArrayList.class);
		for (Employee employee : EMPLOYEE_LIST) {
			SpringLearnConstants.LOGGER.debug(employee.toString());
		}
	}

	public ArrayList<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}

	public Employee getEmployee(int id) throws EmployeeNotFoundException {
//		Employee filteredEmployee = EMPLOYEE_LIST.stream().filter(employee -> employee.getId() == id).findFirst()
//				.orElse(null);
		Employee filteredEmployee = EMPLOYEE_LIST.stream().filter(employee -> employee.getId() == id).findFirst()
				.orElseThrow(() -> new EmployeeNotFoundException());
		return filteredEmployee;
	}

//	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
//		Employee filteredEmployee = EMPLOYEE_LIST.stream().filter(employeeObj -> employeeObj.getId() == employee.getId()).findFirst()
//				.orElseThrow(() -> new EmployeeNotFoundException());
////		System.out.println(filteredEmployee);
//		filteredEmployee.setName(employee.getName());
//		filteredEmployee.setSalary(employee.getSalary());
//		filteredEmployee.setDateOfBirth(employee.getDateOfBirth());
//		filteredEmployee.setPermanent(employee.isPermanent());
//		filteredEmployee.setDepartment(employee.getDepartment());
//		filteredEmployee.setSkills(employee.getSkills());
//		return;
//
//	}
}
