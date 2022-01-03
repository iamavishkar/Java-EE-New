<%@ include file="connection.jsp" %>

<%

String name = request.getParameter("name");
String email = request.getParameter("email");
String mobile = request.getParameter("mobile");
String sql = "insert into students(name, email, mobile)values(?,?,?)";

try{
	Connection con = getConnection(); //establish connection
	PreparedStatement stmt = con.prepareStatement(sql);
	stmt.setString(1, name);
	stmt.setString(2, email);
	stmt.setString(3, mobile);
	int i = stmt.executeUpdate();
	if(i>0){
		response.sendRedirect("select.jsp");
	}
}catch(Exception e){
	e.printStackTrace();
}

%>