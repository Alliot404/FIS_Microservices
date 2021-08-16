package com.fis.employeeservice.bean;

public class Employee {

	String name;
	int Emp_Id;
	String Title;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmp_Id() {
		return Emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		Emp_Id = emp_Id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", Emp_Id=" + Emp_Id + ", Title=" + Title + "]";
	}
	public Employee(String name, int emp_Id, String title) {
		super();
		this.name = name;
		Emp_Id = emp_Id;
		Title = title;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
