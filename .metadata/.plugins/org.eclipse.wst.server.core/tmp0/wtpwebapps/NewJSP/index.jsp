<html>
<head>
<title>JSP Project</title>
</head>
<body>
<%

out.println("Hello jsp");
%>
<br>
<%="SUM= "+sum(8,9) %>
<br>
<%!
int sum(int x,int y){
	return x+y;
}
%>
</body>
</html>