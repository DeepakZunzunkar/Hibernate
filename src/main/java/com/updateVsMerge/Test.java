package com.updateVsMerge;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Employee;
import com.utility.HibernateUtility;

public class Test {
	
	public static void main(String[] args) {
		
		
		/*Client c=new Client();
		Employee e=c.getElementByID(1);
		System.out.println("--------------1-----------");
		e.setName("ajit");
		System.out.println("---------2-------------");
		c.UpdateEmployee(e);*/
		
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
//		Transaction xt = session.beginTransaction();
		Employee e=(Employee) session.get(Employee.class, 1);
		System.out.println(e);
//		e.setName("rakhi"); //if content change update query will be fired and only if transaction is open otherwise nothing will be reflect 
//		xt.commit();
		session.clear();
		System.out.println(session.contains(e));
		session.close();
		
		
		Session session1=factory.openSession();
		Transaction tx1 = session1.beginTransaction();
		
//		Employee e2=(Employee) session1.get(Employee.class, 1);
		
//		System.out.println(session1.contains(e)+" : "+session1.contains(e2));
		e.setName("abbhilash");
		session1.update(e);// A different object with the same identifier value was already associated with the session : [com.model.Employee#1]
//		session1.merge(e);
		
		tx1.commit();
		session1.close();
		
	}

}
