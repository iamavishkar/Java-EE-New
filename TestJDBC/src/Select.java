import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Select")

public class Select extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<h2>Select Page</h2>");
		
		try {
			
			Connection con = MyConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from students";
			ResultSet rs = stmt.executeQuery(sql);
			
			out.println("<table border='1'>");
			out.print("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>Name</th>");
			out.println("<th>Email</th>");
			out.println("<th>Mobile</th>");
			out.println("<th>Edit</th>");
			out.println("<th>Delete</th>");
			out.print("</tr>");
			
			while(rs.next()) {
				
				out.print("<tr>");
				out.print("<td>"+rs.getInt("id")+"</td>");
				out.print("<td>"+rs.getString("name")+"</td>");
				out.print("<td>"+rs.getString("email")+"</td>");
				out.print("<td>"+rs.getLong("mobile")+"</td>");
				out.print("<td><a href='Edit?id="+rs.getInt("id")+"'>Edit</a></td>");
				out.print("<td><a href='Delete?id="+rs.getInt("id")+"'>Delete</a></td>");
				out.print("</tr>");
				
			}
			
			out.println("</table>");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}