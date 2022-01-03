<%@page import="java.sql.*" %>
<%
String text = request.getParameter("id");
try{
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/college","root","");
	String sql = "select name from students where name like '%"+text+"%' ";
	PreparedStatement ptmt = con.prepareStatement(sql);
	//ptmt.setString(1, text);
	ResultSet rs = ptmt.executeQuery();
	while(rs.next()){
%>
<p><%=rs.getString("NAME") %></p>	
<%		
	}
	
}catch(Exception e){
	e.printStackTrace();
}

%>