package com.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//sessionFactory object are not singleton we have to make as singleton
//sessionFactory Objects are immutable
//sessionFactory Object are thread safe on basis of Immutable context 

public class HibernateUtility {

	public static SessionFactory factory=null;

	// to disallow creating objects by other classes.
	private HibernateUtility() {

	}
	//making the Hibernate SessionFactory object as singleton
	public static  SessionFactory getSessionFactory() {

		if(factory==null) {
			synchronized(HibernateUtility.class) {
				Configuration cfg = new Configuration();
				cfg.configure();
				return cfg.buildSessionFactory();
			}
		}
		return factory;
	}

	public static void getResourceCleanUp(Session session, Transaction transaction) {
		transaction.commit();
		session.flush();
		session.close();
	}

}
