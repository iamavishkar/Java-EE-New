<%@ page import="java.sql.*" %>
<%

try{
	
	String email = request.getParameter("email");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/college","root","");
	String sql = "select email from students where email like '%"+email+"%'";
	PreparedStatement stmt = con.prepareStatement(sql);
	ResultSet rs = stmt.executeQuery();
	if(rs.next()){
		out.print("Email exits");
	}else{
		out.print("Email available");
	}
	
}catch(Exception e){
	e.printStackTrace();
}

%>