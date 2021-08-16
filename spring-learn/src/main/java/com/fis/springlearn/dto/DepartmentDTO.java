package com.fis.springlearn.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fis.springlearn.bean.Department;
import com.fis.springlearn.bean.Employee;

public class DepartmentDTO{
	private static final Logger LOGGER = LoggerFactory.getLogger(Department.class);

	private int id;

	private String name;

	private Set<Employee> employeeList;

	public DepartmentDTO() {
		LOGGER.debug("Inside Department Constructor.");

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [id=" + id + ", name=" + name + "]";
	}

}
