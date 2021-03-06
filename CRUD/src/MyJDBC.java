import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/insert")

public class MyJDBC extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		try {
			
	Connection con=MyConnection.getConnection();
			//Statement stmt = con.createStatement(); //create statement
			// sql = "insert into students(name, email, mobile)values('"+name+"', '"+email+"', "+mobile+")";
	String sql="insert into students(name,email,mobile)values(?,?,?)";
	PreparedStatement ptmt=con.prepareStatement(sql);
	ptmt.setString(1, name);
	ptmt.setString(2, email);
	ptmt.setString(3, mobile);
	int i = ptmt.executeUpdate();
			if(i>0) {
				out.print("Record inserted successfully"+i);
				response.sendRedirect("select");
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}