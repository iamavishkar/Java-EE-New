package aman;

import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class MyHCQL {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Student.class);
		crit.add(Restrictions.gt("roll", 102));
		List<Student> list = crit.list();
		for(Student s:list) {
			System.out.println(s.getId());
			System.out.println(s.getName());
			System.out.println(s.getRoll());
		}
		tx.commit();
		session.close();
		factory.close();
	}
}