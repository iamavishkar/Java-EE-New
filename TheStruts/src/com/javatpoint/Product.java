package com.javatpoint;

import com.javatpoint.MyConnection;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.sql.*;
import java.util.*;

public class Product {
private int id;
private String name;
private float price;
ArrayList<Product>list=new ArrayList<>();

public ArrayList<Product> getList() {
	return list;
}
public void setList(ArrayList<Product> list) {
	this.list = list;
}
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
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}

public String insert(){
	String status="error";
	
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");

	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	int i=(int)session.save(this);
	
	tx.commit(); 
	if(i>0) {
		status = display();
	}
	session.close();
	factory.close();
	
	return status;
}

public String display() {
	String status="error";
	
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");

	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	
     Criteria crit=session.createCriteria(Product.class);
     List<Product>list=crit.list();
     
     	tx.commit();
     	status = "display";
		session.close();
		factory.close();
	
	return status;
}

public String delete() {
	String status = "error";
	
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");

	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	Product obj=(Product)session.get(Product.class, id);
	session.delete(obj);
	
		tx.commit(); 
	
		status = "deleted";
	
	session.close();
	factory.close();
	
	return status;
}



}
