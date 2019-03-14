package com.saveVspersist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Employee;
import com.utility.HibernateUtility;

public class Test1 {

	public static void main(String[] args) {

		Employee e1 = new Employee("dinesh", "dinesh@gmail.com", 25000.00);
		Employee e2 = new Employee("omkar", "omkar@gmail.com", 2500.00);

		SessionFactory factory = HibernateUtility.getSessionFactory();
		
		Session session1=factory.openSession();
		Transaction tx	=	session1.beginTransaction();
		
		Integer l=(Integer) session1.save(e1);
		System.out.println("id :"+l);
		session1.flush();
		
		tx.commit();
		session1.close();
		
	/*	Session session2=factory.openSession();
		Transaction tx2=session2.beginTransaction();
		session2.persist(e1);
		tx2.commit();
		session2.close();*/
		
	}
}
