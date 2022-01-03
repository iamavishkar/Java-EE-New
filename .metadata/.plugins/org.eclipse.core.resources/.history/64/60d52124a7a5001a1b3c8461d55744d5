package com.javatpoint;

import java.sql.*;

public class MyConnection{
	public static Connection con = null;
	public static Connection getConnection() {
		try {
			
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost/mydb";
			String username = "root";
			String password = "";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			
		}catch(Exception e) {
			
		}
		return con;
	}
}