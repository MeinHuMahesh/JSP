package DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.Room;

public class RoomDAO {
	
	
	
	private Connection connection;
	
	public RoomDAO(Connection connection) {
		this.connection=connection;
	}
	public Room getByID(int id) {
		Room room = new Room();
		try {
			String query="select * from room where room_id="+id+";";
			PreparedStatement ps =connection.prepareStatement(query);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				//Room room =new Room();
				room.setRoom_id(rs.getInt("room_id"));
				room.setRoom_number(rs.getString("room_number"));
				room.setCheckin_date(rs.getString("check_in_date"));
				room.setCheckout_date(rs.getString("check_out_date"));
				room.setGuest_Name(rs.getString("guestname"));
				room.setBooking_status(rs.getString("booking_status"));				
			}
			connection.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return room;
	}
	public int addRoom(Room room,HttpServletRequest request,HttpServletResponse response,PrintWriter out) throws ServletException, IOException {
			
		if(room.getGuest_Name().isEmpty() && room.getCheckin_date().isEmpty() && room.getCheckout_date().isEmpty()) {
			try {
				String query ="insert into room(room_number,booking_status) values(?,?);";
				PreparedStatement ps =connection.prepareStatement(query);
				ps.setString(1, room.getRoom_number());
				ps.setString(2, room.getBooking_status());
				ps.executeUpdate();
				ps.close();
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				response.setContentType("text/html");
				out.println("<h3 style='color:red'>Error Occured :"+e.getMessage()+"</h3>");
				RequestDispatcher rd =request.getRequestDispatcher("/bookroom.jsp");
				rd.include(request, response);
				return 0;
			}
			
		}else {
			try {
				String query="insert into room(room_number,check_in_date,check_out_date,guestname,booking_status) values(?,?,?,?,?);";
				PreparedStatement ps =connection.prepareStatement(query);
				ps.setString(1, room.getRoom_number());
				ps.setString(2, room.getCheckin_date());
				ps.setString(3,room.getCheckout_date());
				ps.setString(4, room.getGuest_Name());
				ps.setString(5, room.getBooking_status());
				
				ps.executeUpdate();
				ps.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				response.setContentType("text/html");
				out.println("<h3 style='color:red'>Error Occured :"+e.getMessage()+"</h3>");
				RequestDispatcher rd =request.getRequestDispatcher("/bookroom.jsp");
				rd.include(request, response);
				return 0;
			}		
		}
		return 1;
	}
	public int UpdateRoom(Room room,HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int user_id=(Integer)session.getAttribute("user_id");
		if(room.getCheckin_date().isEmpty() && room.getCheckout_date().isEmpty() && room.getGuest_Name().isBlank()) {
			try {
				String query="update room set check_in_date=?,check_out_date=?,guestname=?,booking_status=?,where room_id=?;";
				PreparedStatement ps =connection.prepareStatement(query);
				ps.setString(1, "2023-01-01");
				ps.setString(2, "2023-01-01");
				ps.setString(3, room.getGuest_Name());
				ps.setString(4, room.getBooking_status());
			
				ps.setInt(5, room.getRoom_id());
			
				ps.executeUpdate();
				ps.close();
				connection.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				response.setContentType("text/html");
				out.println("<h3 style='color:red'>Error Occured :"+e.getMessage()+"</h3>");
				RequestDispatcher rd =request.getRequestDispatcher("/UpdateRoom.jsp");
				rd.include(request, response);
				return 0;
			}
		}else {
			try {
				String query="update room set check_in_date=?,check_out_date=?,guestname=?,booking_status=?,user_id=? where room_id=?;";
				PreparedStatement ps =connection.prepareStatement(query);
				ps.setString(1, room.getCheckin_date());
				ps.setString(2, room.getCheckout_date());
				ps.setString(3, room.getGuest_Name());
				ps.setString(4, room.getBooking_status());
				ps.setInt(5, user_id);
				ps.setInt(6, room.getRoom_id());
			
				ps.executeUpdate();
				ps.close();
				connection.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				response.setContentType("text/html");
				out.println("<h3 style='color:red'>Error Occured :"+e.getMessage()+"</h3>");
				RequestDispatcher rd =request.getRequestDispatcher("/UpdateRoom.jsp");
				rd.include(request, response);
				return 0;
			}
		}
		return 1;
	}
	public void deletebyID(int id) {
		try {
			String query="delete from room where room_id="+id+";";
			PreparedStatement ps =connection.prepareStatement(query);
			ps.executeUpdate();
			ps.close();
			connection.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public List<Room> getRoomsByUser(int user_id){
		List<Room> rooms = new ArrayList<>();
		try {
			String query="select * from room where user_id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, user_id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Room room = new Room();
				room.setRoom_id(rs.getInt("room_id"));
				room.setRoom_number(rs.getString("room_number"));
				room.setCheckin_date(rs.getString("check_in_date"));
				room.setCheckout_date(rs.getString("check_out_date"));
				room.setGuest_Name(rs.getString("guestname"));
				room.setBooking_status(rs.getString("booking_status"));
				
				rooms.add(room);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rooms;
	}
	public List<Room> getRoomsByBookingStatus(String booking_status){
		List<Room> rooms =new ArrayList<>();
		try {
			String query="select * from room where booking_status=?";
			PreparedStatement ps =connection.prepareStatement(query);
			ps.setString(1, booking_status);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				Room room = new Room();
				room.setRoom_id(rs.getInt("room_id"));
				room.setRoom_number(rs.getString("room_number"));
				room.setCheckin_date(rs.getString("check_in_date"));
				room.setCheckout_date(rs.getString("check_out_date"));
				room.setGuest_Name(rs.getString("guestname"));
				room.setBooking_status(rs.getString("booking_status"));
				
				rooms.add(room);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rooms;
	}
	public List<Room> getAllRooms(){
		List<Room> rooms =new ArrayList<>();
		try {
			String query="select * from room order by room_number asc;";
			PreparedStatement ps =connection.prepareStatement(query);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				Room room =new Room();
				room.setRoom_id(rs.getInt("room_id"));
				room.setRoom_number(rs.getString("room_number"));
				room.setCheckin_date(rs.getString("check_in_date"));
				room.setCheckout_date(rs.getString("check_out_date"));
				room.setGuest_Name(rs.getString("guestname"));
				room.setBooking_status(rs.getString("booking_status"));
				
				rooms.add(room);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return rooms;
	}

}
