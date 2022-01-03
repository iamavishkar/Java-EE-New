package hbm;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Student {
	private int id;
	private String name;
	private String degree;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
public int insert() {
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");

	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	
	Transaction tx = session.beginTransaction();
          int i=(int)session.save(this);

	
	tx.commit();
	session.close();
	factory.close();
	return i;
}
}
