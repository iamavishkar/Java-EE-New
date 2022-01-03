import java.sql.*;

class MyConnection{
	public static Connection con = null;
	public static Connection getConnection(){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); //register driver
			con = DriverManager.getConnection("jdbc:mysql://localhost/college","root",""); //create connection
			
		}catch(Exception exp) {
			
		}
		
		return con;
	}
}