<%@ include file="connection.jsp" %>

<html>
<head>
<title>Edit Page</title>
</head>
<body>

<h1>Edit Page</h1>
<br />

<%
String id = request.getParameter("id");
try{
	
	Connection con = getConnection(); //establish connection
	String sql = "select * from students where id=?";
	PreparedStatement stmt = con.prepareStatement(sql);
	stmt.setString(1, id);
	ResultSet rs = stmt.executeQuery();
	while(rs.next()){
		String name = rs.getString("name");
		String email = rs.getString("email");
		Long mobile = rs.getLong("mobile");
%>

<form action="update.jsp" method="post">
<input type="hidden" name="id" value="<%= id %>" />
Name: <input type="text" name="name" value="<%= name %>" /><br />
Name: <input type="text" name="email" value="<%= email %>" /><br />
Name: <input type="text" name="mobile" value="<%= mobile %>" /><br />
<input type="submit" value="Update Data" />
</form>

<%
	}
}catch(Exception e){
	e.printStackTrace();
}
%>

</body>
</html>