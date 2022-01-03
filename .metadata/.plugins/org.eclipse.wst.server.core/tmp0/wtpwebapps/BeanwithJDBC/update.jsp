<%@page import="bean.Students" %>

<html>
<head>
<title>Update Page</title>
</head>
<body>

<h1>Update Page</h1>
<br />

<jsp:useBean id="obj" class="bean.Students" />
<jsp:setProperty property="*" name="obj" />
<% 
boolean status = obj.update();
if(status){
%>

<h2>Record updated successfully!</h2>
<br />
Go to the <a href="select.jsp">Select Page</a>

<%
}
%>