package aman;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SimpleTest {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Query query=session.createQuery("from Student");
		query.setFirstResult(0);
		query.setMaxResults(2);
		   List<Student>list=query.list();
		   for(Student s:list) {
			   System.out.println(s.getId());
			   System.out.println(s.getName());
			   System.out.println(s.getPhone());
			   System.out.println(s.getRoll());
		   }

		Transaction tx = session.beginTransaction();
		
		tx.commit();
		session.close();
		factory.close();
	}
}