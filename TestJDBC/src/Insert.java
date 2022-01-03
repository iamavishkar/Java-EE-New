import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Insert")

public class Insert extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.print("<h2>Insert Page</h2>");
		out.println("<form action='' method='post'>");
		out.println("Name: <input type='text' name='name' /><br />");
		out.println("Email: <input type='text' name='email' /><br />");
		out.println("Mobile: <input type='text' name='mobile' /><br />");
		out.println("<input type='submit' value='Submit Data' />");
		out.println("</form>");
		out.println("</html></body>");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		Connection con=null;
		try {
			
	     con = MyConnection.getConnection();
			con.setAutoCommit(false);
			String sql="insert into students(name, email, mobile)values(?,?,?)";
			//String sql2="insert into students(name, email, mobile)values(?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			//PreparedStatement stmt2 = con.prepareStatement(sql2);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, mobile);
			stmt.addBatch();
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3,mobile);
			
			stmt.addBatch();
			int[] i = stmt.executeBatch();
			
			
		
			if(i!=null) {
				response.sendRedirect("Select");
			}
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			}
}