import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Edit")

public class Edit extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<h2>Edit Page</h2>");
		
		String id = request.getParameter("id");
		
		try {
			
			Connection con = MyConnection.getConnection();
			
			String sql = "select * from students where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				out.print("<form action='Update' method='post'>");
				out.print("<input type='hidden' name='id' value="+rs.getInt("id")+" /><br />");
				out.print("Name: <input type='text' name='name' value="+rs.getString("name")+" /><br />");
				out.print("Email: <input type='text' name='email' value="+rs.getString("email")+" /><br />");
				out.print("Mobile: <input type='text' name='mobile' value="+rs.getString("mobile")+" /><br />");
				out.print("<input type='submit' value='Edit Data'>");
				out.print("</form>");
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}