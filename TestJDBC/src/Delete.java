import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Delete")

public class Delete extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<h2>Delete Page</h2>");
		
		String id = request.getParameter("id");
		
		try {
			
			Connection con = MyConnection.getConnection();
			String sql = "delete from students where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			int i = stmt.executeUpdate();
			if(i>0) {
				out.print("Record deleted successfully");
				out.print("<br />");
				out.print("Go to <a href='Select'>Select Page</a> .");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}