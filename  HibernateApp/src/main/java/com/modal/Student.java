package com.modal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
///@Table(name="student") // if you need to use different name for this entity
public class Student {

	@Id
	private int stuId;
	@Column
	private String stuName;
	@Column
	private double avgMarks;
	
	// parametered constructor not required
	
	@Embedded
	Address address;
	
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public double getAvgMarks() {
		return avgMarks;
	}
	public void setAvgMarks(double avgMarks) {
		this.avgMarks = avgMarks;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", avgMarks=" + avgMarks + "]";
	}
	
	
}
