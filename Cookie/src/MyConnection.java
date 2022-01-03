import java.sql.Connection;
import java.sql.DriverManager;

class MyConnection{
	
	public static Connection con=null;
	public static Connection getConnection() {
		try {
		Class.forName("com.mysql.jdbc.Driver"); //register driver
		con = DriverManager.getConnection("jdbc:mysql://localhost/college","root",""); //set connection
	}
		catch(Exception e) {
			
		}
		return con;
	}
}