package com.tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.modal.Address;
import com.modal.Student;

public class InsertAddress {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Student st = new Student();
		st.setStuId(102);
		st.setStuName("jhon");
		st.setAvgMarks(90.90);
		
		
		Address address = new Address();
		address.setDoorNo("121/2A");
		address.setCity("New York City");
		address.setStreet("Broadway");
		st.setAddress(address);
		session.save(st);
		
		Transaction tx =  session.beginTransaction(); // to permanantly save data
		tx.commit();

	}

}
