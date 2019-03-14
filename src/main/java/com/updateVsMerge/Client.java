package com.updateVsMerge;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Employee;
import com.utility.HibernateUtility;

public class Client {

	public Employee getElementByID(Integer id) {
		
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Employee e=(Employee) session.get(Employee.class, id);
		session.close();
		return e;
	}
	
	public void UpdateEmployee(Employee employee) {
		
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.update(employee);
		
		tx.commit();
		session.close();
	}
	
	public static void main(String[] args) {
		
		/*Client c=new Client();
		Employee e=c.getElementByID(1);
		System.out.println("--------------1-----------");
		e.setName("ajit");
		System.out.println("---------2-------------");
		c.UpdateEmployee(e);*/
		
		SessionFactory factory=HibernateUtility.getSessionFactory();
		Session session=factory.openSession();
		
		Employee e1=(Employee) session.get(Employee.class, 1);
		e1.setName("thhh");
		session.close();
		
		Session session1=factory.openSession();
		Transaction tx=session1.beginTransaction();
		Employee e2=(Employee) session1.get(Employee.class, 1);		//if we comment this line then and update then no error will occur and update succesfully 
		//e2 object in persistent state with id 100
		
		//below we try to make on detached object with id 100 to persistent state by using update method of hibernate
		//It occurs the exception NonUniqueObjectException because e2 object is having employee with same empid as 100. In order //to avoid this exception we are using merge like given below instead of session.update(emp1);
		session1.update(e1);
//		session1.merge(e1);//it merge the object state with emp2
		
		
		tx.commit();
		session1.close();
		
		
	}
	
}
