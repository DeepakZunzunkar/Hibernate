package com.saveVspersist;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Employee;
import com.utility.HibernateUtility;

public class Client {
	
	public static void main(String[] args) {
		
		Employee e1=new Employee("dinesh","dinesh@gmail.com",25000.00);
		Employee e2=new Employee("omkar","omkar@gmail.com",2500.00);
		
		SessionFactory factory=HibernateUtility.getSessionFactory();
		
		//with respect to transaction boundary save method will work out of transaction boundary but persist will not work 
		/*Session session1=factory.openSession();
		Transaction tx1=session1.beginTransaction();
		tx1.commit();
		Integer id=(Integer) session1.save(e1);
		System.out.println("id :"+id);
//		session1.persist(e2);
		session1.close();*/
		
		//it work even if we dont open the transaction 
		Session session1=factory.openSession();
		Integer l=(Integer) session1.save(e1);
		System.out.println("id :"+l);
		session1.flush();
//		session1.refresh(e1);
		session1.close();
		
		/*Session session1=factory.openSession();
		Transaction tx1=session1.beginTransaction();
		Integer l=(Integer) session1.save(e1);
		System.out.println("id :"+l);
//		session1.flush();
		tx1.commit();
		session1.close();
		*/
		
		Session session2=factory.openSession();
		Transaction tx2=session2.beginTransaction();
		
		session2.persist(e1);
		//if we perform changes before commit that will reflect after commit if we perform changes in that object ,will not reflect 
		e1.setName("golum");
		tx2.commit();
//		e1.setName("lord");
		session2.close();
		
		
		
		
		
		factory.close();
	}
}
