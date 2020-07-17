package com.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	
	//@JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = { @JoinColumn(name = "COURSE_ID") })
	
	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = { @JoinColumn(name = "COURSE_ID") })
	// otherwise it will create jointables id as CourseList_Course_id
	List<Cource> courseList = new ArrayList<Cource>();
	
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
	public List<Cource> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Cource> courseList) {
		this.courseList = courseList;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", avgMarks=" + avgMarks + ", address=" + address
				+ ", courseList=" + courseList + "]";
	}

	
	
}
