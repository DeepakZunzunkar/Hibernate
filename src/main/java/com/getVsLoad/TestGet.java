package com.getVsLoad;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Employee;
import com.utility.HibernateUtility;

public class TestGet {

	public static void main(String[] args) {
		
		SessionFactory factory=HibernateUtility.getSessionFactory();
		
		Session session=factory.openSession();
		Employee e=(Employee) session.get(Employee.class,1); 
		System.out.println(e);
		session.close();
		System.out.println("================================================");
		Session session1=factory.openSession();
		Employee e1=(Employee) session1.get(Employee.class,1);
		Employee e2=(Employee) session1.get(Employee.class,1);
		
		System.out.println(e.getEmial());
		
		System.out.println(e1==e);
		System.out.println(e1==e2);
		
		session1.close();

	}
}
