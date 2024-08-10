<%@page import="DAO.RoomDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entity.Room" %>
<%@ page import="DatabaseConnection.DatabaseConnection" %>
<%@ page import="DAO.RoomDAO" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@include file="cookies.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>



<h2 style="text-align: center">Room List </h2>
<%
	DatabaseConnection dbcon = new DatabaseConnection();
	RoomDAO roomDAO = new RoomDAO(dbcon.connect());
	
	List<Room> rooms = roomDAO.getAllRooms();
%>
<div class="table-responsive" style="margin:0 auto;margin-top:5%; margin-bottom:5%;  width: 90%;border: 3px solid black;padding: 10px;" >
<table class="table table-bordered table-primary" border="1">

<thead>
	<tr>
	<th>Room ID</th>
	<th>Room Number</th>
	<th>Check In Date</th>
	<th>Check Out Date</th>
	<th>Guest Name</th>
	<th>Booking Status</th>
	<th>Update</th>
	<th>Delete</th>
	</tr>
</thead>
<tbody>
	<%
		for(Room room:rooms){
	%>
	<tr>
		<td><%= room.getRoom_id() %></td>
		<td><%= room.getRoom_number() %></td>
		<td><%= room.getCheckin_date() %></td>
		<td><%= room.getCheckout_date() %></td>
		<td><%= room.getGuest_Name() %></td>
		<td><%= room.getBooking_status() %></td>
		<td>
		<form action="UpdateServlet" method="post">
			<input type="hidden" name="room_id" value="<%=room.getRoom_id() %>">
			<input type="hidden" name="room_number" value="<%=room.getRoom_number() %>">
			<input class="btn btn-primary" type="submit" value="Update">
		</form>
		</td>
		<td>
		<form action="DeleteServlet" method="post">
			<input type="hidden" name="room_id" value="<%=room.getRoom_id() %>">
			<input class="btn btn-danger" type="submit"  value="Delete">
		</form>
		</td>
	</tr>
	<%
		}
	%>
</tbody>
</table>
</div>
</body>
</html>