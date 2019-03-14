package com.clearVsCloseVsevict;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Employee;
import com.utility.HibernateUtility;

public class TestClose {

public static void main(String[] args) {
		
		SessionFactory factory1=HibernateUtility.getSessionFactory();
		
		Session session1 =factory1.openSession();
		Transaction tx1=session1.beginTransaction();
		
//		Employee e1=(Employee)session1.get(Employee.class, 1);
		Employee e2=(Employee)session1.get(Employee.class, 2);
		//emp1 and emp2 are in persistent state
		
		
		
//		e1.setName("vaibhav");
		e2.setName("Dinesh");
		
		session1.close(); //session already close exception raised 

		
		tx1.commit();
		session1.close();
		
	}

}
