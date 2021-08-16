package com.fis.springlearn.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fis.springlearn.bean.Department;
import com.fis.springlearn.bean.Employee;
import com.fis.springlearn.bean.Skill;

public class EmployeeDTO {
	private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);

	private int id;

	private String name;

	private double salary;

	private boolean permanent;

	private Date dateOfBirth;

	private DepartmentDTO departmentDTO;

	private Set<SkillDTO> skillList;

	public EmployeeDTO() {
		LOGGER.debug("Inside Employee Constructor.");
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public DepartmentDTO getDepartment() {
		return departmentDTO;
	}

	public void setDepartment(DepartmentDTO departmentDTO) {
		this.departmentDTO = departmentDTO;
	}

	public Set<SkillDTO> getSkillList() {
		return skillList;
	}

	public void setSkillList(Set<SkillDTO> skillList) {
		this.skillList = skillList;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + ", departmentDTO=" + departmentDTO + ", skillList=" + skillList
				+ "]";
	}

}
