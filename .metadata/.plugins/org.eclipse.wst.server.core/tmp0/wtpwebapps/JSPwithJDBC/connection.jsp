<%@page import="java.sql.*" %>
<%!
public static Connection con = null;
public static Connection getConnection(){
	try{
		
		String driver = "com.mysql.jdbc.Driver"; //driver
		String url = "jdbc:mysql://localhost/college"; //database url
		String username = "root"; //database username
		String password = ""; //database password
		
		Class.forName(driver); //load driver
		con = DriverManager.getConnection(url, username, password); //establish connection
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return con;
}
%>