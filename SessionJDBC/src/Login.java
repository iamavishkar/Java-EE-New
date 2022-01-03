import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Login")

public class Login extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<h1>Login Page</h1>");
		out.print("<form action='Login' method='post'>");
		out.print("Email: <input type='text' name='email' /><br />");
		out.print("Password: <input type='text' name='pwd' /><br />");
		out.print("<input type='submit' value='Login' />");
		out.print("</form>");
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		try {
			
			Connection con = MyConnection.getConnection();
			String sql = "select * from users where email=? and password=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, pwd);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("username", email);
				response.sendRedirect("Welcome");
			}else {
				out.print("Invalid email and password");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}