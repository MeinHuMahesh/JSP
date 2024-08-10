package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RoomDAO;
import DatabaseConnection.DatabaseConnection;
import Entity.Room;

/**
 * Servlet implementation class ProcessBookRoom
 */
@WebServlet("/ProcessBookRoom")
public class ProcessBookRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessBookRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int room_id=Integer.parseInt(request.getParameter("room_id"));
		String room_number=request.getParameter("roomNumber");
		String check_in_date=request.getParameter("checkInDate");
		String check_out_date=request.getParameter("checkOutDate");
		String guest_name=request.getParameter("guestName");
		String booking_status=request.getParameter("bookingstatus");
		
		Room updatedRoom = new Room();
		updatedRoom.setRoom_id(room_id);
		updatedRoom.setRoom_number(room_number);
		updatedRoom.setCheckin_date(check_in_date);
		updatedRoom.setCheckout_date(check_out_date);
		updatedRoom.setGuest_Name(guest_name);
		updatedRoom.setBooking_status(booking_status);
		
		
		DatabaseConnection dbcon = new DatabaseConnection();
		RoomDAO roomDAO = new RoomDAO(dbcon.connect());
		int i=roomDAO.UpdateRoom(updatedRoom,request,response,out);
		if(i>0) {
			request.setAttribute("flag", i);
			response.sendRedirect("ViewAvailableRooms.jsp");
			
		}
	}

}
