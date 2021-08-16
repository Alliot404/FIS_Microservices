package com.fis.springlearn.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "department")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Department {
	private static final Logger LOGGER = LoggerFactory.getLogger(Department.class);
	@Id
	@Column(name = "dp_id")
	@NotNull
	@Positive
	private int id;

	@Column(name = "dp_name")
	@NotNull
	@NotBlank
	@Size(min = 1, max = 30, message = "Invalid department name")
	private String name;

//	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	@OneToMany(mappedBy = "department")
//	@JsonIgnore
//	@JsonBackReference
	private Set<Employee> employeeList;

	public Department() {
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
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
