package com.fis.springlearn.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fis.springlearn.bean.Employee;
import com.fis.springlearn.bean.Skill;

public class SkillDTO {
	private static final Logger LOGGER = LoggerFactory.getLogger(Skill.class);

	private int id;

	private String name;

	private Set<EmployeeDTO> employeeList;

	public SkillDTO() {
		LOGGER.debug("Inside Skill Constructor.");

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

	public Set<EmployeeDTO> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Set<EmployeeDTO> empSkillsDTO) {
		this.employeeList = empSkillsDTO;
	}

	@Override
	public String toString() {
		return "SkillDTO [id=" + id + ", name=" + name + "]";
	}

}
