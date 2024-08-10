package DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.User;

public class UserDAO {
	private Connection connection;
	
	public UserDAO(Connection connection) {
		this.connection=connection;
	}
	public User getByEmail(String email) {
		User user = new User();
		try {
			String query="select * from users where email='"+email+"';";
			PreparedStatement ps =connection.prepareStatement(query);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				user.setUser_id(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
			}
			ps.close();
			connection.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}
	public User getUser(String email,String password,HttpServletRequest request ,HttpServletResponse response,PrintWriter out) throws ServletException, IOException {
		User getuser = new User();
		try {
			String query ="select * from users where email=? and password=?";
			PreparedStatement ps =connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				getuser.setName(rs.getString("name"));
				getuser.setUser_id(rs.getInt("id"));
				getuser.setPhone(rs.getString("phone"));
				getuser.setEmail(rs.getString("email"));
				getuser.setPassword(rs.getString("password"));
			}
			ps.close();
			connection.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setContentType("text/html");
			out.print("<h3 style='color:red'>Error Occured :"+e.getMessage()+"</h3>");
			RequestDispatcher rd =request.getRequestDispatcher("/Login.jsp");
			rd.include(request, response);
		}
		return getuser;
	}
	public int adduser(User user,HttpServletRequest request,HttpServletResponse response,PrintWriter out) throws ServletException, IOException {
		try {
			String query="insert into users(name,phone,email,password) values(?,?,?,?);";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.executeUpdate();
			ps.close();
			connection.close();	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setContentType("text/html");
			out.println("<body>");
			out.println("<h3 style='color:red'>Error Occured :"+e.getMessage()+"</h3>");
			out.println("</body>");
			RequestDispatcher rd =request.getRequestDispatcher("/register.jsp");
			rd.include(request, response);
			return 0;
		}
		return 1;
	}
	public List<User> getAllUsers(){
		List<User> Users = new ArrayList<>();
		try {
			String query="select * from users;";
			PreparedStatement ps =connection.prepareStatement(query);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				User user  = new User();
				user.setUser_id(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				
				Users.add(user);
			}
			ps.close();
			connection.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Users;
	}

}
