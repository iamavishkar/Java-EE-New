import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/edit")

public class Edit extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			String id=request.getParameter("id");
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); //register driver
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/college","root",""); //set connection
			Statement stmt = con.createStatement(); //create statement
			String sql="select * from students where id="+id;
		 ResultSet rs = stmt.executeQuery(sql);
		 out.println("<form action='update' method='post'>");
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
				out.println("<td><input type='text' name='id' value="+rs.getInt(1)+" readonly></td>");
				out.println("<td><input type='text' name='name' value="+rs.getString(2)+"></td>");
				out.println("<td><input type='text' name='email' value="+rs.getString(3)+"></td>");
				out.println("<td><input type='text' name='mobile' value="+rs.getString(4)+"></td>");
				out.println("<td><input type='submit' value='update'></td>");
				
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</form>");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}