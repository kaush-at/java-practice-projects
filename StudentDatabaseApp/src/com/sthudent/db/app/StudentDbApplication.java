package com.sthudent.db.app;

import java.util.Scanner;

public class StudentDbApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many students you need to add ?");
		int noOfStudents = sc.nextInt();
		Student [] students = new Student[noOfStudents];
		
		String fName;
		String lName;
		int year;
		int subjectCount;
		
		for(int i = 0; i < noOfStudents; i++) {
			System.out.println("Enter the student first name : ");
			fName = sc.next();
			
			System.out.println("Enter the student last name : ");
			lName = sc.next();
			
			System.out.println("Enter the student class year \n1 for Freshman\n2 for Sophmore\n3 for Junior\n4 for Senior: ");
			year = sc.nextInt();
			
			System.out.println("How many Subjects would you like to enroll ? ");
			subjectCount = sc.nextInt();
			String[] subjects = new String[subjectCount];
			
			int counter = 0;
			while(counter < subjectCount) {
				System.out.println("Please enter the Subject you gonna enroll");
				String userInput;
				String first = sc.next(); // Read past the text EOL character(s) -> skip the white line issue
				String second = sc.nextLine();
				userInput = first +" " + second; 
				subjects[counter] = userInput;
				counter++;
				}
			

			students[i]  = new Student(fName, lName, year, subjects);
			
			System.out.println("How much would you like to pay initially :");
			int paidAmount = sc.nextInt();
			
			int balanceToPay = students[i].getBalance(paidAmount);
			System.out.println("After you pay $"+paidAmount+" Your remaining balance is "+balanceToPay);
		}
		System.out.println();
		System.out.println("Thanks for all and wish you GOOD LUCK..");

	}

}
