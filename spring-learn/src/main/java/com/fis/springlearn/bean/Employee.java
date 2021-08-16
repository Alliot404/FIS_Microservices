package com.fis.springlearn.bean;

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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "employee")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee {
	private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);

	@Id
	@Column(name = "em_id")
	@NotNull
	@Positive
	private int id;

	@Column(name = "em_name")
	@NotNull
	@NotBlank
	@Size(min = 1, max = 30, message = "Invalid employee name")
	private String name;

	@Column(name = "em_salary")
	@NotNull
	@Min(value = 0, message = "Invalid Salary")
	private double salary;

	@Column(name = "em_permanent")
	@NotNull
	private boolean permanent;

	@Column(name = "em_date_of_birth")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
//	@Past
	private Date dateOfBirth;

	@ManyToOne
	@JoinColumn(name = "em_dp_id")
//	@JsonManagedReference
	private Department department;

	@ManyToMany(fetch = FetchType.EAGER)
//	@ManyToMany
	@JoinTable(name = "employee_skill", joinColumns = @JoinColumn(name = "es_em_id"), inverseJoinColumns = @JoinColumn(name = "es_sk_id"))
//	@JsonManagedReference
	private Set<Skill> skillList;
//	private Skill[] skills;

	public Employee() {
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(Set<Skill> skillList) {
		this.skillList = skillList;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + ", department=" + department + ", skillList=" + skillList + "]";
	}

//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
//				+ ", dateOfBirth=" + dateOfBirth + ", department=" + department + ", skills=" + Arrays.toString(skills)
//				+ "]";
//	}

}
