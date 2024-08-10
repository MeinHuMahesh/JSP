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

import DAO.UserDAO;
import DatabaseConnection.DatabaseConnection;
import Entity.User;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		String name =request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		
		User newuser = new User();
		newuser.setName(name);
		newuser.setPhone(phone);
		newuser.setEmail(email);
		newuser.setPassword(pass);
		
		DatabaseConnection dbcon = new DatabaseConnection();
		UserDAO userDAO = new UserDAO(dbcon.connect());
			int i=userDAO.adduser(newuser, request, response, out);
			if(i>0) {
				response.sendRedirect("Login.jsp");
			}
		} 
	
	}


