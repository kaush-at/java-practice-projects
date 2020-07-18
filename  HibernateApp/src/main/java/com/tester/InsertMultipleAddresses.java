package com.tester;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.modal.Address;
import com.modal.Employee;

public class InsertMultipleAddresses {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Employee employee = new Employee();
		employee.setEmpId(100);
		employee.setEmpName("william");
		employee.setSalary(20000.00);
		
		
		Address address = new Address();
		address.setDoorNo("200");
		address.setCity("kansas city");
		address.setStreet("butler ave");
		
		Address address1 = new Address();
		address1.setDoorNo("89");
		address1.setCity("Uttah city");
		address1.setStreet("donald road");
		
		List<Address> addressList = new ArrayList<Address>(); 
		addressList.add(address);
		addressList.add(address1);
		
		
		employee.setAddressList(addressList);
		
		session.save(employee);
		
		Transaction tx =  session.beginTransaction(); 
		tx.commit();

	}

}
