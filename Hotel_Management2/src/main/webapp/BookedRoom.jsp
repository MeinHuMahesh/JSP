<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="cookies.jsp" %>
<%@ page import="DatabaseConnection.DatabaseConnection" %>
<%@ page import="DAO.RoomDAO" %>
<%@ page import="java.util.*" %>
<%@ page import="Entity.Room" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
DatabaseConnection dbcon = new DatabaseConnection();
RoomDAO roomDAO = new RoomDAO(dbcon.connect());

int user_id=(Integer)session.getAttribute("user_id");
List<Room> rooms=roomDAO.getRoomsByUser(user_id);
	
%>
<h2 style="text-align: center;">Booked Rooms </h2>
<div class="table-responsive" style="margin:0 auto;margin-top:5%;width: 90%;border: 3px solid black;padding: 10px;" >
<table class="table table-bordered table-primary" border="1">

<thead>
	<tr>
	<th>Room ID</th>
	<th>Room Number</th>
	<th>Check In Date</th>
	<th>Check Out Date</th>
	<th>Guest Name</th>
	<th>Booking Status</th>
	
	
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
		
		
	</tr>
	<%
		}
	%>
</tbody>
</table>
</div>
</body>
</html>