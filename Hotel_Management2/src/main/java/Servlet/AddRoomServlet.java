package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RoomDAO;
import DatabaseConnection.DatabaseConnection;
import Entity.Room;

/**
 * Servlet implementation class BookRoomServlet
 */
@WebServlet("/AddRoomServlet")
public class AddRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomServlet() {
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
		PrintWriter out =response.getWriter();
		
		String roomnumber =request.getParameter("roomNumber");
		String check_in_date=request.getParameter("checkInDate");
		String check_out_date=request.getParameter("checkOutDate");
		String guestname =request.getParameter("guestName");
		String booking_status=request.getParameter("bookingstatus");
		
		
		Room addroom = new Room();
		addroom.setRoom_number(roomnumber);
		addroom.setCheckin_date(check_in_date);
		addroom.setCheckout_date(check_out_date);
		addroom.setGuest_Name(guestname);
		addroom.setBooking_status(booking_status);
		
		DatabaseConnection dbcon = new DatabaseConnection();
		RoomDAO roomDAO = new RoomDAO(dbcon.connect());
		
		int i=roomDAO.addRoom(addroom, request, response, out);
		
		
		if(i>0) {
			response.sendRedirect("ViewRooms.jsp");
		}		
	}

}
