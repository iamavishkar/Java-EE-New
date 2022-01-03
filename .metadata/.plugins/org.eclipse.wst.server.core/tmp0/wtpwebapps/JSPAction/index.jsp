
<%
int a=10;

if(a>9){
	%>
	<jsp:forward page="success.jsp"/>
	<%
} else{
	%>
	<jsp:include page="error.jsp"/>
		<%
}

%>