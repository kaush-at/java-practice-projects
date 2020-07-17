package com.tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.modal.Address;
import com.modal.Cource;
import com.modal.Student;

public class InsertStuCource {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		Address address = new Address();
		address.setDoorNo("222");
		address.setCity("san fransisco");
		address.setStreet("california street"); 
		
		Cource crs = new Cource();
		crs.setCourseId(10);
		crs.setCourseName("Data Structures");
		crs.setCourseFee(350.00);
		
		Student st = new Student();
		st.setStuId(105);
		st.setStuName("Doe");
		st.setAvgMarks(79.99);
		st.setAddress(address);
		
		st.getCourseList().add(crs);
		crs.getStuList().add(st);
		
		session.save(st);
		session.save(crs);
		
		Transaction tx =  session.beginTransaction(); 
		tx.commit();
	}

}
