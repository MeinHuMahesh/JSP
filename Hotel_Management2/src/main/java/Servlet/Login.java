package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import DatabaseConnection.DatabaseConnection;
import Entity.User;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public Login() {
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
		HttpSession session=request.getSession();
		PrintWriter out =response.getWriter();
		String email =request.getParameter("email");
		String pass=request.getParameter("password");
		User getuser = new User();
		DatabaseConnection dbcon = new DatabaseConnection();
		UserDAO userDAO = new UserDAO(dbcon.connect());
		getuser=userDAO.getUser(email, pass,request,response,out);
		
		
		if(getuser !=null) {
			
			session.setAttribute("username", getuser.getName());
			session.setAttribute("user_id",getuser.getUser_id());
			
			
			RequestDispatcher rd =request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			
		}	
		else {
			
			response.setContentType("text/html");
			out.println("<h3 style='color:red'>Error Occured : User Email and Password Not Matched !!</h3>");
			RequestDispatcher rd =request.getRequestDispatcher("/Login.jsp");
			rd.include(request, response);	
			}
		
	}

}
