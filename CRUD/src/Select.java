import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/select")

public class Select extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			
		try {
			
			
			Connection con = MyConnection.getConnection(); //set connection
			Statement stmt = con.createStatement(); //create statement
			String sql="select * from students";
		 ResultSet rs = stmt.executeQuery(sql);
		 out.println("<table border='2'>");
		 out.println("<tr>");
		 out.println("<th>ID</th>");
		 out.println("<th>NAME</th>");
		 out.println("<th>EMAIL</th>");
		 out.println("<th>MOBILE</th>");
		 out.println("<th colspan='2'>ACTION</th>");
		 out.println("</tr>");
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getInt(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getLong(4)+"</td>");
				out.println("<td><a href='delete?id="+rs.getInt(1)+"'>DELETE</a></td>");
				out.println("<td><a href='edit?id="+rs.getInt(1)+"'>EDIT</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}