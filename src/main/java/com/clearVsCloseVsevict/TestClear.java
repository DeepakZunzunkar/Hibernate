package com.clearVsCloseVsevict;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Employee;
import com.utility.HibernateUtility;

public class TestClear {
	
	public static void main(String[] args) {
		
		SessionFactory factory1=HibernateUtility.getSessionFactory();
		
		Session session1 =factory1.openSession();
		Transaction tx1=session1.beginTransaction();
		
		Employee e1=(Employee)session1.get(Employee.class, 1);
		Employee e2=(Employee)session1.get(Employee.class, 2);
		//emp1 and emp2 are in persistent state
		
		e1.setName("suraj");
		e2.setName("naveen");
		
		//emp1 and emp2 are in detached state.
		session1.clear();		//if we are not write this line it will update the record in db 
		
		
		tx1.commit();
		session1.close();
		
	}

}
//After calling session.clear(), emp1 and emp2 objects are disconnected from the session object. i.e emp1 and emp2 objects are moved from persistent state to detached state.
//The table is not updated even though transaction is committed becuase emp1 and emp2 are in non-transaction state.