<%@ include file="connection.jsp" %>

<html>
<head>
<title>Update Page</title>
</head>
<body>

<h1>Update Page</h1>
<br />

<%
String id = request.getParameter("id");
String name = request.getParameter("name");
String email = request.getParameter("email");
String mobile = request.getParameter("mobile");
try{
	
	Connection con = getConnection(); //establish connection
	String sql = "update students set name=?, email=?, mobile=? where id=?";
	PreparedStatement stmt = con.prepareStatement(sql);
	stmt.setString(1, name);
	stmt.setString(2, email);
	stmt.setString(3, mobile);
	stmt.setString(4, id);
	stmt.executeUpdate();		
%>

<p>Record updated successfully</p>
<br />
Go to <a href="select.jsp">Select Page</a>.

<%
}catch(Exception e){
	e.printStackTrace();
}
%>

</body>
</html>