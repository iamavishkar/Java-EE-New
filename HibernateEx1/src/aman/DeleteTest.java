package aman;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteTest {

	public static void main(String[] args) {
		int id=2;
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Student s = (Student)session.get(Student.class,id);
		s.setName("Ramesh");
		Transaction tx = session.beginTransaction();
		session.update(s);
		System.out.println("Object deleted successfully.....!!");
		tx.commit();
		session.close();
		factory.close();
	}
}