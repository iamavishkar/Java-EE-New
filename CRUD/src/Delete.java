import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/delete")

public class Delete extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); //register driver
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/college","root",""); //set connection
			Statement stmt = con.createStatement(); //create statement
			String sql = "delete from students where id="+id;
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				out.print("Record inserted successfully"+i);
				response.sendRedirect("select");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}