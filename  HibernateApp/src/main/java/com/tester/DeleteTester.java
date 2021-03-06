package com.tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.modal.Student;

public class DeleteTester {

	
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Student student = session.get(Student.class, 102);
		
		session.delete(student);
		
		
		Transaction tx =  session.beginTransaction(); 
		tx.commit();

		session.close();
	}
}
