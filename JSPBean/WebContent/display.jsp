<%@page import="java.util.ArrayList"%>
<%@ page import="bean.Student" %>
<html>
<head>
<title>Display Page</title>
</head>
<body>

<h1>Display Page</h1>
<br />
<jsp:useBean id="ob" class="bean.Student"/>
<%

ArrayList<Student>list=ob.select();
for(Student s:list){
	out.println(s.getId());
	out.println(s.getName());
	out.print(s.getEmail());
	out.println(s.getMobile());
	out.println("<br>");
}
%>

</body>
</html>