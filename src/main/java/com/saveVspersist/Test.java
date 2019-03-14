package com.saveVspersist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Employee;
import com.utility.HibernateUtility;

public class Test {

	public static void main(String[] args) {

		Employee e1 = new Employee("dinesh", "dinesh@gmail.com", 25000.00);
		Employee e2 = new Employee("omkar", "omkar@gmail.com", 2500.00);

		SessionFactory factory = HibernateUtility.getSessionFactory();
		
		Session session2=factory.openSession();
		
		session2.save(e1);
		e1.setName("golum");
		session2.close();
		
		//mtsql version proble is there because it is not be reflected in table 
		Session session3=factory.openSession();
		Employee obj=(Employee) session3.get(Employee.class, 1);
		System.out.println(obj);
	}
}
