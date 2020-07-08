package com.kaush.dto;

public class Employee {

	private int id;
	private String name;
	private String password;
	private String department;
	private double salary;
	//private static int counter = 1;
	
	public Employee() {
		
	}
	
	public Employee(String name, String password, String department, double salary) {
		super();
		this.name = name;
		this.password = password;
		this.department = department;
		this.salary = salary;
		//this.id = id;
		
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
}
