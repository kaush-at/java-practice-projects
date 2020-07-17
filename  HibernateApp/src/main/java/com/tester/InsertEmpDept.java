package com.tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.modal.Address;
import com.modal.Depatrment;
import com.modal.Employee;

public class InsertEmpDept {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		Address address = new Address();
		address.setDoorNo("121/2A");
		address.setCity("New York City");
		address.setStreet("Broadway"); 
		
		Depatrment dpt1 = new Depatrment();
		dpt1.setDeptId(1);
		dpt1.setDeptName("IT");
		dpt1.setLocation("New York");
		
		Employee employee = new Employee();
		employee.setEmpId(200);
		employee.setEmpName("kaush");
		employee.setSalary(292929.00);
		

		employee.getAddressList().add(address);
		employee.setDepartment(dpt1);
		
		session.save(dpt1); // when it is entity you have to save it when it is not entity no need to worry 
		session.save(employee);


		Transaction tx =  session.beginTransaction(); 
		tx.commit();
	}

}
