<%@ page import = "bean.Students" %>

<jsp:useBean id="obj" class="bean.Students" />
<jsp:setProperty property="*" name="obj" />
<%
boolean status = obj.insert();
if(status){
	response.sendRedirect("select.jsp");
}
%>