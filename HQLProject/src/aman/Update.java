package aman;

import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Update {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		Query query=session.createQuery("update Student set name=:n,phone=:p where id=:i");
		query.setParameter("n","ansh");
		query.setParameter("p","8888");
		query.setParameter("i", 2);
		int i=query.executeUpdate();
		System.out.println(i);
		
		tx.commit();
		session.close();
		factory.close();
	}
}