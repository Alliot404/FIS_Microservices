package com.fis.employeeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.employeeservice.bean.Employee;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@GetMapping("/{number}")
	public Employee getEmployee(@PathVariable long number) {
		return new Employee("Abhi", 12345, "Developer");
	}
}
