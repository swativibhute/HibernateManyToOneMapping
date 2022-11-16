package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("Hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Address address = new Address();
		address.setCity("Kothali");
		address.setCountry("India");
		address.setState("maharashtra");
		address.setPincode(123045);
		
		
		Employee employee = new Employee("Swati", "SwatiVibhute1234@gmail.com", address);
		Employee employee2 = new Employee("Samantha", "Samantha234@gmail.com", address);

		session.save(employee);
		session.save(employee2);
		transaction.commit();
		session.close();
	}

}
