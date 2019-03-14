package com.getVsLoad;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Employee;
import com.utility.HibernateUtility;

public class TestLoad {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtility.getSessionFactory();

		Session session = factory.openSession();
		Employee e = (Employee) session.load(Employee.class, 1);
		System.out.println(e);
		Employee ee = (Employee) session.load(Employee.class, 1);
		System.out.println(ee);
		System.out.println(ee == e);
		session.close();
System.out.println("=============================================");
		Session session1 = factory.openSession();
		Employee e1 = (Employee) session1.load(Employee.class, 1);
//		System.out.println(e1);

//		System.out.println(e1 == e);

		session1.close();
	}
}
