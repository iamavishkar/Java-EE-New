package aman;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SelectTest {

	public static void main(String[] args) {
		int id=2;
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
	     Criteria crit=session.createCriteria(Student.class);
	     List<Student>list=crit.list();
	     for(Student s:list) {
	    	 System.out.println("Record fetched "+s.getId()+" "+s.getName()+" "+s.getPhone()+" "+s.getDegree());
	     }
		
		tx.commit();
		session.close();
		factory.close();
	}
}