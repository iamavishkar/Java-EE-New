<html>
<head>
<title>JSP Expression Language Example!</title>
</head>
<body>

<h1>JSP Expression Language Example!</h1>
<br />

<form action="getdata.jsp" method="post">
Name:<input type="text" name="name" /><br />
Email:<input type="text" name="email" /><br />
Mobile:<input type="text" name="mobile" /><br />
<input type="submit" value="Submit Data" />
</form>

<%
session.setAttribute("username", "ASR2626"); //sessionScope value set

Cookie ck = new Cookie("course_year","2ndYear"); //Cookie value set
response.addCookie(ck); //Cookie added to response
%>

</body>
</html>