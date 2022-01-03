package bean;
import java.sql.*;

class MyConnection{
	public static Connection con = null;
	public static Connection getConnection() {
		
		try {
			
			String driver = "com.mysql.jdbc.Driver"; //driver
			String url = "jdbc:mysql://localhost/college"; //database url
			String username = "root"; //username
			String password = ""; //password
			
			Class.forName(driver); //load driver
			con = DriverManager.getConnection(url, username, password); //establish connection
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}