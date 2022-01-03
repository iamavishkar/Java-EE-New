import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Update")

public class Update extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<h2>Update Page</h2>");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		try {
			
			Connection con = MyConnection.getConnection();
			String sql = "update students set name=?, email=?, mobile=? where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, mobile);
			stmt.setString(4, id);
			int i = stmt.executeUpdate();
			if(i>0) {
				out.println("Record edited successfully");
				out.print("<br />");
				out.println("Go to <a href='Select'>Select Page</a> .");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}