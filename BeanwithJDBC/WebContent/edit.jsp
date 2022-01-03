<%@page import="java.util.*" %>
<%@page import="bean.Students" %>

<html>
<head>
<title>Edit Page</title>
</head>
<body>

<h1>Edit Page</h1>
<br />

<jsp:useBean id="obj" class="bean.Students" />
<jsp:setProperty property="id" name="obj"/>
<%
ArrayList<Students> listEdit = obj.edit();
for(Students s:listEdit){
%>

<form action="update.jsp" method="post">
<input type="hidden" name="id" value="<%= s.getId() %>" />
Name: <input type="text" name="name" value="<%= s.getName() %>" /><br />
Email: <input type="text" name="email" value="<%= s.getEmail() %>" /><br />
Mobile: <input type="text" name="mobile" value="<%= s.getMobile() %>" /><br />
<input type="submit" value="Submit" />
</form>


<%
}
%>

</body>
</html>