<%@ include file="connection.jsp" %>

<html>
<head>
<title>Select Page</title>
</head>
<body>

<h1>Select Page</h1>
<br />

<table border="2">

<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<%
try{
	Connection con = getConnection(); //establish connection
	String sql = "select * from students";
	PreparedStatement stmt = con.prepareStatement(sql);
	ResultSet rs = stmt.executeQuery();
	while(rs.next()){
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String email = rs.getString("email");
		Long mobile = rs.getLong("mobile");
%>

<tr>
<td><%= id %></td>
<td><%= name %></td>
<td><%= email %></td>
<td><%= mobile %></td>
<td><a href="edit.jsp?id=<%= id %>">Edit</a></td>
<td><a href="delete.jsp?id=<%= id %>">Delete</a></td>
</tr>

<%
	}
}catch(Exception e){
	e.printStackTrace();
}
%>

</table>

</body>
</html>