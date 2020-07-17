package com.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeDetails")
public class Employee {

	@Id
	private int empId;
	@Column
	private String empName;
	@Column
	private double salary;

	@ElementCollection 
	@JoinTable(name="Address", joinColumns=@JoinColumn(name="empId"))
	List<Address> addressList = new ArrayList<Address>();

	@ManyToOne
	Depatrment department;
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public Depatrment getDepartment() {
		return department;
	}

	public void setDepartment(Depatrment department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", addressList="
				+ addressList + ", department=" + department + "]";
	}
	
	 
	
}
