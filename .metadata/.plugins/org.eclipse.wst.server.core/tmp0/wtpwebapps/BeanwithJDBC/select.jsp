<%@page import="java.util.*" %>
<%@page import="bean.Students" %>

<html>
<head>
<title>Select Page</title>
</head>
<body>

<h1>Select Page</h1>
<br />

<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<jsp:useBean id="obj" class="bean.Students" />
<%
ArrayList<Students> list = obj.select();
for(Students s:list){
%>
<tr>
<td><%= s.getId() %></td>
<td><%= s.getName() %></td>
<td><%= s.getEmail() %></td>
<td><%= s.getMobile() %></td>
<td><a href="edit.jsp?id=<%= s.getId() %>">Edit</td>
<td><a href="delete.jsp?id=<%= s.getId() %>">Delete</td>
</tr>
<%
}
%>
</table>

</body>
</html>