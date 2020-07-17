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
	
	//putting multiple addresses in Employee table is not possible
	//@ElementCollection  // hibernate recognize this as a collection object and persist in to seperate table
	// for any type of collection you can use this ()this will name as our table Employee_addressList if i need i can change the name using
	// @JoingTable
	// when we create address table it will create id as Employee_empId => class name +its Id (you can gives different name if you need)
	// instead of using this @JoinTable(name="Address") we can modify as 
	@ElementCollection 
	@JoinTable(name="Address", joinColumns=@JoinColumn(name="empId"))
	List<Address> addressList = new ArrayList<Address>();

	// relationships only done with the entity => Entity has its own identification number
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
