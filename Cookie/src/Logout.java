import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Logout")

public class Logout extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie user = null;
		
		Cookie ck3[] = request.getCookies();
		if(ck3!=null) {
			for(Cookie c:ck3) {
				if(c.getName().equals("email")) {
					user = c;
					break;
				}
			}
		}
		
		if(user!=null) {
			
			user.setMaxAge(0);
			response.addCookie(user);
			response.sendRedirect("index.html");
			
		}else {
			
			response.sendRedirect("index.html");
			
		}
		
	}
}