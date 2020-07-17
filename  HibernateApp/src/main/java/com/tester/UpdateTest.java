package com.tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.modal.Student;

public class UpdateTest {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Student st = new Student();
		st.setStuId(101);
		st.setStuName("kaush");
		st.setAvgMarks(100);
		session.update(st);  // me line eka witarai wenas save ekata wada
		
		Transaction tx =  session.beginTransaction(); // to permanantly save data
		tx.commit();

	}

}
