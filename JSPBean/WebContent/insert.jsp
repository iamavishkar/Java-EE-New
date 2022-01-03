<%@page import="bean.Student" %>

<%
Student ob=new Student();
ob.setName("aman");
out.println(ob.getName());
%>

<br />

<jsp:useBean id="s" class="bean.Student"/>
<jsp:setProperty property="*" name="s" />
<jsp:getProperty property="name" name="s"/>

<br />

<jsp:getProperty property="email" name="s"/>

<br />

<jsp:getProperty property="mobile" name="s"/>
<%
boolean status=s.insert();
if(status){
	response.sendRedirect("display.jsp");
}
%>