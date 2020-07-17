package com.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cource {
	@Id
	private int courseId;
	@Column
	private String courseName;
	@Column
	private double courseFee;
	
	@ManyToMany(mappedBy="courseList")
	List<Student>  stuList= new ArrayList<Student>();
	
	public Cource() {}
	
	public Cource(int courseId, String courseName, double courseFee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseFee = courseFee;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}

	@Override
	public String toString() {
		return "Cource [courseId=" + courseId + ", courseName=" + courseName + ", courseFee=" + courseFee + ", stuList="
				+ stuList + "]";
	}


	
	

}
