package com.tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.modal.Student;

public class SelectTest {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		// retrieve data from db 1 parameter is a entity class 2nd parameter is id(primary key)
		Student student = session.get(Student.class, 101);
		System.out.println(student);
		session.close();
		

	}

}
