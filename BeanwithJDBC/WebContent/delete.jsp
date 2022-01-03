<%@page import="java.util.*" %>
<%@page import="bean.Students" %>

<html>
<head>
<title>Delete Page</title>
</head>
<body>

<h1>Delete Page</h1>
<br />

<jsp:useBean id="obj" class="bean.Students" />
<jsp:setProperty property="id" name="obj"/>
<%
boolean status = obj.delete();
if(status){
%>

<h2>Record deleted successfully!</h2>
<br />
Go to the <a href="select.jsp">Select Page</a>

<%
}
%>

</body>
</html>