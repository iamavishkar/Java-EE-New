<%@page import="hbm.Student" %>

<jsp:useBean id="ob" class="hbm.Student"/>
<jsp:setProperty property="*" name="ob"/>
<%
  int a=ob.insert();
out.println(a);
%>