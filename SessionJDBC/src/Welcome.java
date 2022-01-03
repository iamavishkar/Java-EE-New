import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Welcome")

public class Welcome extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<h1>Welcome Page</h1>");
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			
			String username = (String)session.getAttribute("username");
			out.print("<h3>Welcome, "+username+"</h3>");
			out.print("<br />");
			out.print("<a href='Logout'>Logout</a>");
			
		}else {
			out.print("You must login first");
			response.sendRedirect("Login");
		}
		
	}
}