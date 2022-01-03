import java.sql.*;

class MyConnection{
	
	public static Connection con=null;
	
	public static Connection getConnection(){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); //load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost/college","root",""); //create connection
			
		}catch(Exception e) {
			
		}
		return con;
	}
}