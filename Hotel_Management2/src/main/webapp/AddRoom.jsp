<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="cookies.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>


<div class=" d-flex align-items-center justify-content-center" style="margin: auto;margin-top:10%; height:50%;width: 60%;border: 3px solid black;padding: 10px;">

 <form action="AddRoomServlet" method="post">
 	<div class="form-group">
 	<h2>Add a Room</h2>
 	<table>
 		<tr>
 			<td><label class="form-text" for="roomNumber">Room Number:</label></td>
 			<td><input class="form-control" type="text" id="roomNumber" name="roomNumber" placeholder="Enter Room Number" required></td>
 		</tr>
 		<tr>
 			<td><label class="form-text" for="checkInDate">Check-in Date:</label></td>
 			<td><input class="form-control" type="date" id="checkInDate" name="checkInDate" ></td>
 		</tr>
 		<tr>
 			<td><label class="form-text" for="checkOutDate">Check-out Date:</label></td>
 			<td><input class="form-control" type="date" id="checkOutDate" name="checkOutDate" ></td>
 		</tr>
 		<tr>
 			<td><label class="form-text" for="guestName">Guest Name:</label></td>
 			<td><input class="form-control" type="text" id="guestName" placeholder="Enter Guest Name" name="guestName"></td>
 		</tr>
 		<tr>
 			<td><label class="form-text" for="bookingstatus">Booking Status :</label></td>
 			<td>
 				<select id="bookingstatus" class="form-control" name="bookingstatus" required>
        			<option value="">Select</option>
        			<option value="Available">Available</option>
        			<option value="Booked">Booked</option>
        		</select>
 			</td>
 		</tr>
 		<tr>
 		<td><input class="btn btn-primary" type="submit" value="Add Room"></td>
 		</tr>
 	</table> 
 	</div>   
    </form>
 </div>   
</body>
</html>