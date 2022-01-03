<%@ include file="connection.jsp" %>

<html>
<head>
<title>Delete Page</title>
</head>
<body>

<h1>Delete Page</h1>
<br />

<%
String id = request.getParameter("id");
try{
	
	Connection con = getConnection(); //establish connection
	String sql = "delete from students where id=?";
	PreparedStatement stmt = con.prepareStatement(sql);
	stmt.setString(1, id);
	stmt.executeUpdate();		
%>

<p>Record deleted successfully</p>
<br />
Go to <a href="select.jsp">Select Page</a>.

<%
}catch(Exception e){
	e.printStackTrace();
}
%>

</body>
</html>