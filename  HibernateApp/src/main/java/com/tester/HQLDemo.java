package com.tester;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.modal.Student;

public class HQLDemo {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();

		Session session = factory.openSession();

		Query query = session.createQuery("from Student");
		
		List<Student> studentList = query.list();
		
		System.out.println(studentList);
		session.close();

	}

}
