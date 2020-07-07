package com.sthudent.db.app;

public class Student {

	private String firstName;
	private String lastName;
	private int gradedYear;
	private String studentId;
	private int tutionBalance;
	private int costOfCource = 600;
	private String [] subjects;
	private static int id = 1000;
	
	public Student(String firstName, String lastName, int gradedYear, String [] subjects ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradedYear = gradedYear;
		this.subjects = subjects;
		
		setStudentId();
		setTutionBalance(this.subjects.length);
		
		System.out.println("Student name id "+firstName+" "+lastName+"\nStudent Id is "+studentId+"\nYour tution fee total is : "+tutionBalance);
		System.out.println("You have enrolled to :" );
		for(String subject : subjects) {
			System.out.println("\t"+subject);
		}
	}
	
	private void setStudentId() {
		id++;
		this.studentId =  this.gradedYear +""+id;
	}
	
	private void setTutionBalance(int subjectCount) {
		this.tutionBalance = subjectCount * costOfCource;
	}
	
	public int getBalance(int paidAmmount) {
		return tutionBalance - paidAmmount;
	}
	
	
}
