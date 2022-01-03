<%
String data = request.getParameter("num"); //getting data
int num = Integer.parseInt(data); //parsing it to integer
//int num = (int)request.getParameter("num");
for(int i=1; i<=10; i++){
	int res = num*i;
	out.print(num+" x "+i+" = "+res);
	out.print("<br />");
}
%>