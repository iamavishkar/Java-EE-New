import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Logout")

public class Logout extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			session.invalidate();
			out.print("Logged out successfully");
			response.sendRedirect("Login");
		}else {
			response.sendRedirect("Login");
		}
		
	}
}