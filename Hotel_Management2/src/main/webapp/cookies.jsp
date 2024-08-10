<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<%
session=request.getSession();

String userSessionname=(String)session.getAttribute("username");
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	 <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Home</a>
            </li>
            <li class="nav-item dropdown">
               <a class="nav-link dropdown-toggle" id="AdminDropDown"  role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Admin</a>
                    <div class="dropdown-menu" >
                        <a class="dropdown-item"  href="AddRoom.jsp">Add Room</a>
                        <a class="dropdown-item" href="ViewRooms.jsp">View Rooms</a>
                       
                    </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="UserDropDown"  role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">User</a>
                    <div class="dropdown-menu" aria-labelledby="UserDropDown" >
                        <a class="dropdown-item"  href="ViewAvailableRooms.jsp">Available Room</a>
                   		<a  class="dropdown-item" onclick="disableLink()" id="BookedRooms" href="BookedRoom.jsp">Booked Rooms</a>
                    </div>
            </li>
            <li class="nav-item">
            	<a class="nav-link" href="About.jsp">About us</a>
            </li>
        </ul>
        <span class="" style="font-size:25px; margin-left:10%; margin-right:10%; color:white; white-space: nowrap;">Hotel Grand Shalimaar</span>
        <div class="ml-auto">
        <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
        <li class="nav-item dropdown">
        	 <a class="nav-link dropdown-toggle"  id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Welcome <%= userSessionname %></a>
             <div class="dropdown-menu" aria-labelledby="navbarDropdown">
             	<a class="dropdown-item" href="register.jsp">Register</a>
                <a class="dropdown-item" href="Login.jsp">Login</a>
             	<a class="dropdown-item" href="Logout.jsp">Logout</a>
             </div>   
        </li>  
        </ul>
        </div>
        </div>
        
</nav>
<script>
	function disableLink(){
	var username='<%=userSessionname%>';
	
	if(username=='null'){
				document.getElementById('BookedRooms').addEventListener('click',function(event){
						event.preventDefault();

						this.classList.add('dropdown-item disabled');
					});
				
				
				
		}
	}
	
	function disabledropdown(){
        var usersessionname='<%=userSessionname%>';
        var admindropdown=document.getElementById('AdminDropDown');
        var userdropdown=document.getElementById('UserDropDown');
        
        
        if(usersessionname=='Admin'){
            admindropdown.disabled=false;
            userdropdown.disabled=true;
            }
       
        
        else{
				admindropdown.disabled=true;
				userdropdown.disabled=false;
				
            }
	}
	
	window.onload=disabledropdown;

  
        
</script>
 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>