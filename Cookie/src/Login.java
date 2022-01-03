import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Login")

public class Login extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		try {
			
		Connection con=MyConnection.getConnection();
		//Statement stmt=con.createStatement();
		String sql="select * from users where email=? and password=?";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1, email);
		ptmt.setString(2, pwd);
		ResultSet rs=ptmt.executeQuery();
		if(rs.next() ) {
			
			Cookie ck = new Cookie("email", email);
			
			ck.setMaxAge(1000);
			
			
			response.addCookie(ck);
			
			
			response.sendRedirect("Home");
			
		}else {
			
			out.println("Incorrect Email and Password");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			
		}		
		}catch(Exception e) {
			
		}
	}
}