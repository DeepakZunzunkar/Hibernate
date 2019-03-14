package secondLevel_cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import com.model.Employee;
import com.utility.HibernateUtility;

public class Client {

	public static void main(String[] args) {
		
		Employee e1=new Employee("dinesh","dinesh@gmail.com",25000.00);
		Employee e2=new Employee("omkar","omkar@gmail.com",2500.00);
		
		SessionFactory factory=HibernateUtility.getSessionFactory();
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		
		
		session.flush();
		tx.commit();
		session.clear();
		
		Statistics stats = factory.getStatistics();
		stats.setStatisticsEnabled(true); 
		
		System.out.println("insetion completed..!");
		//Session session2= facotry.openSession();
		//session2.evict(st1);
		
		
		System.out.println("last statemtne..");
		Session session3= factory.openSession();
		Employee dbst2 = (Employee)session3.get(Employee.class,1); //query
		System.out.println(dbst2);
		
		System.out.println("fetching ob2");
		Employee dbst3 = (Employee)session.get(Employee.class,2); /// NO
		System.out.println(dbst3);
		
		
		
		
	}
}
