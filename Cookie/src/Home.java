import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Home")

public class Home extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String user = null;
		
		Cookie ck3[] = request.getCookies();
		if(ck3!=null) {
			for(Cookie c:ck3) {
				if(c.getName().equals("email")) {
					user = c.getValue();
					break;
				}
			}
		}
		
		if(user==null) {
			
			response.sendRedirect("index.html");
			
		}else {
			
			out.println("Hello, "+user);
			out.println("<br>");
			out.print("<a href='Logout'>Logout</a>");
			
		}
		
	}
}