package com.fis.userservice.bean;

public class User {
	
	String name;
	int PhoneNumber;
	String eamil;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", PhoneNumber=" + PhoneNumber + ", eamil=" + eamil + "]";
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, int phoneNumber, String eamil) {
		super();
		this.name = name;
		PhoneNumber = phoneNumber;
		this.eamil = eamil;
	}
	
	
	

}
