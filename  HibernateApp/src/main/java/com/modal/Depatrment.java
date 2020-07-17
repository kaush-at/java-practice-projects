package com.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Depatrment {
	@Id
	private int deptId;
	@Column
	private String deptName;
	@Column  
	private String location;
	
	//employee should contains department id (with one to one -> one employee have one department Id)
	@OneToMany(mappedBy="department")  // to stop this mapping and only work other side mapping with employee(in other relation side object refference)
	List<Employee> empList = new ArrayList<Employee>();
	
	public Depatrment() {
		
	}
	
	public Depatrment(int deptId, String deptName, String location) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.location = location;
	}
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	
	

}
