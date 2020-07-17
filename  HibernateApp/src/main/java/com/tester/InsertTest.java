package com.tester;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.modal.Student;

public class InsertTest {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Student st = new Student();
		st.setStuId(102);
		st.setStuName("jhon");
		st.setAvgMarks(90.90);
		session.save(st);
		
		Transaction tx =  session.beginTransaction();
		tx.commit();

	}

}
