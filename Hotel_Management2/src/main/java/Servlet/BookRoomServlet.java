package Servlet;

import java.io.IOException;

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
@WebServlet("/BookRoomServlet")
public class BookRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRoomServlet() {
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
		int roomid =Integer.parseInt(request.getParameter("room_id"));
		DatabaseConnection dbcon = new DatabaseConnection();
		RoomDAO existingrooms = new RoomDAO(dbcon.connect());
		Room room =existingrooms.getByID(roomid);
		request.setAttribute("bookroom", room);
		RequestDispatcher rd = request.getRequestDispatcher("BookRoom.jsp?room_id="+roomid);
		rd.forward(request, response);
	}

}
