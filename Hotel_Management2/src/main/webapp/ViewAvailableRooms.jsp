<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="DatabaseConnection.DatabaseConnection" %>
<%@ page import="DAO.RoomDAO" %>
<%@ page import="java.util.*" %>
<%@ page import="Entity.Room" %>
 <%@include file="cookies.jsp" %>
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
	String booking_status="Available";
	List<Room> rooms = roomDAO.getRoomsByBookingStatus(booking_status);
%>
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
	<th>Book</th>
	
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
		<form id="myBookingForm" action="BookRoomServlet" method="post">
			<input type="hidden" name="room_id" value="<%=room.getRoom_id() %>">
			<input type="hidden" name="room_number" value="<%=room.getRoom_number() %>">
			<input class="btn btn-success" type="button" onclick="Nouser()" value="Book">
		</form>
		</td>
		
	</tr>
	<%
		}
	%>
</tbody>
</table>
</div>


<script>
		function Nouser(){
					var username ='<%= userSessionname%>';
					if(username =="null"){
							alert("You Need to Login for Booking !!!!");
							window.location.href="Login.jsp";
						}
					else{
							document.getElementById("myBookingForm").submit();
						}
		}
</script>
</body>
</html>