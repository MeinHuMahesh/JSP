<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="cookies.jsp" %>
<%@ page import="Entity.Room" %>
<%@ page import="DAO.RoomDAO" %>
<%@ page import="DatabaseConnection.DatabaseConnection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class=" d-flex align-items-center justify-content-center" style="margin: auto;margin-top:10%; height:50%;width: 60%;border: 3px solid black;padding: 10px;">
	<form action="ProcessUpdateRoom" method="post">
		<%
			Room currentroom =(Room)request.getAttribute("updateroom");
		%>
		<div class="form-group">
		<h2>Update Form</h2>
		<table>
		<tr>
			<td><label class="form-text" for="room_id">Room ID:</label></td>
			<td> <input class="form-control" type="text" id="room_id" name="room_id" value="<%= currentroom.getRoom_id() %>" readonly></td>
		</tr>
		<tr>
			<td><label class="form-text" for="roomNumber">Room Number:</label></td>
			<td><input class="form-control" type="text" id="roomNumber" name="roomNumber" value="<%= currentroom.getRoom_number()%>" readonly></td>
		</tr>
		<tr>
			<td><label class="form-text" for="checkInDate">Check-in Date:</label></td>
			<td><input class="form-control" type="date" id="checkInDate" name="checkInDate" value="<%=currentroom.getCheckin_date()%>" ></td>
		</tr>
		<tr>
			<td><label class="form-text" for="checkOutDate">Check-out Date:</label></td>
			<td><input class="form-control" type="date" id="checkOutDate" name="checkOutDate" value="<%= currentroom.getCheckout_date() %>" ></td>
		</tr>
		<tr>
			<td><label class="form-text" for="guestName">Guest Name:</label></td>
			<td><input class="form-control" type="text" id="guestName" name="guestName" value="<%= currentroom.getGuest_Name() %>"></td>
		</tr>
		<tr>
			<td><label class="form-text" for="bookingstatus">Booking Status :</label></td>
			<td><select id="bookingstatus" class="form-control" name="bookingstatus" required>
        		<option value="">Select</option>
        		<option value="Available">Available</option>
        		<option value="Booked">Booked</option>
        		<option selected value="<%=currentroom.getBooking_status() %>"><%=currentroom.getBooking_status() %> </option>
        		</select>
       		</td>
		</tr>
		<tr><td><input class="btn btn-primary" type="submit" value="Update Room"></td>
		<td></td>
		</tr>
		</table> 
		</div>  
	</form>
</div>

</body>
</html>