package bean;
import java.sql.*;
import java.util.ArrayList;

public class Students{
	private int id;
	private String name, email;
	private Long mobile;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	
	//Insert data code here
	public boolean insert() {
		boolean status = false;
		
		try {
			
			Connection con = MyConnection.getConnection(); //establish connection
			String sql = "insert into students(name, email, mobile)values(?,?,?)";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, name);
			pt.setString(2, email);
			pt.setLong(3, mobile);
			int i = pt.executeUpdate();
			if(i>0) {
				status = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	//select code here
	public ArrayList<Students> select() {
		ArrayList<Students> list = new ArrayList<>();
		
		try {
			
			Connection con = MyConnection.getConnection(); //establish connection
			String sql = "select * from students";
			PreparedStatement pt = con.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();
			while(rs.next()) {
				
				Students sobj = new Students();
				sobj.setId(rs.getInt("id"));
				sobj.setName(rs.getString("name"));
				sobj.setEmail(rs.getString("email"));
				sobj.setMobile(rs.getLong("mobile"));
				list.add(sobj);
			}
			
		}catch(Exception e) {
			
		}
		
		return list;
		
	}
	
	//delete code here
	public boolean delete() {
		boolean status = false;
		
		try {
			
			Connection con = MyConnection.getConnection();
			String sql = "delete from students where id=?";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, id);
			int i = pt.executeUpdate();
			if(i>0) {
				status = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	//edit code here
	public ArrayList<Students> edit(){
		ArrayList<Students> listEdit = new ArrayList<>();
		
		try {
			
			Connection con = MyConnection.getConnection();
			String sql = "select * from students where id=?";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, id);
			ResultSet rs = pt.executeQuery();
			while(rs.next()) {
				
				Students obj = new Students();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setEmail(rs.getString("email"));
				obj.setMobile(rs.getLong("mobile"));
				listEdit.add(obj);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return listEdit;
	}
	
	//update code here
	public boolean update() {
		boolean status = false;
		
		try {
			
			Connection con = MyConnection.getConnection();
			String sql = "update students set name=?, email=?, mobile=? where id=?";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(4, id);
			pt.setString(1, name);
			pt.setString(2, email);
			pt.setLong(3, mobile);
			int i = pt.executeUpdate();
			if(i>0) {
				status = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
}

