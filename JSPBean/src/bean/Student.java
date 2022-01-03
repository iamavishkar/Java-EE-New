package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Student{
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private String name, email;
	private long mobile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public boolean insert() {
		boolean status=false;
		try {
			
			Connection con=MyConnection.getConnection();
			String sql="insert into students(name,email,mobile)values(?,?,?)";
			PreparedStatement ptmt=con.prepareStatement(sql);
			ptmt.setString(1, name);
			ptmt.setString(2, email);
			ptmt.setLong(3, mobile);
			int i = ptmt.executeUpdate();
					if(i>0) {
						
						status=true;
					}			
				}catch(Exception e){
					e.printStackTrace();
				}
		return status;
	}
	
	public ArrayList<Student> select(){
		ArrayList list=new ArrayList<>();
try {
			
			Connection con=MyConnection.getConnection();
					String sql="select * from students";
			PreparedStatement ptmt=con.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
					while(rs.next()) {
						
				Student s=new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setMobile(rs.getLong(4));
				list.add(s);
					}			
				}catch(Exception e){
					e.printStackTrace();
				}
		return list;
	}
	
}