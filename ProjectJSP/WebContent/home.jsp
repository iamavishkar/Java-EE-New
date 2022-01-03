<%@page import="java.sql.*" %>
<%
String email = request.getParameter("email");
String pwd = request.getParameter("password");
out.print("Email is = "+email);
out.print("<br />");
out.print("Password is = "+pwd);
try {
	
	Class.forName("com.mysql.jdbc.Driver"); //register driver
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/college","root",""); //set
		//Statement stmt = con.createStatement(); //create statement
		// sql = "insert into students(name, email, mobile)values('"+name+"', '"+email+"', "+mobile+")";
String sql="insert into users(email,password)values(?,?)";
PreparedStatement ptmt=con.prepareStatement(sql);
ptmt.setString(1, email);
ptmt.setString(2, pwd);
int i = ptmt.executeUpdate();
		if(i>0) {
			out.print("Record inserted successfully"+i);
			response.sendRedirect("select");
		}			
	}catch(Exception e){
		e.printStackTrace();
	}

%>
