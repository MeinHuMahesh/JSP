<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="cookies.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" >
</head>
<body>
<div class=" d-flex align-items-center justify-content-center" style="margin: auto;margin-top:10%;width: 60%;border: 3px solid black;padding: 10px;">
<form action="register" method="post">

<div class="form-group">
<h2>Registration Form</h2>
<table style="padding: 5px;" >
<tr style="margin-top: 5%;">
	<td class="form-text"><b>Name</b></td>
    <td><input class="form-control" type="text" placeholder="Enter Name" name="name" id="name" required></td>
</tr>
<tr>
	<td class="form-text"><b>Phone</b></td>
    <td><input class="form-control" type="text" placeholder="Enter Phone" name="phone" id="phone" required></td>
</tr>
<tr>
	<td class="form-text"><b>Email</b></td>
    <td><input class="form-control" type="email" placeholder="Enter Email" name="email" id="email" required></td>
</tr>
<tr>
	<td class="form-text"><b>Password</b></td>
    <td><input class="form-control" type="password" placeholder="Enter Password" name="password" id="password" required></td>
</tr>
<tr>
<td><input class="btn btn-primary" type="submit" value="Register"></td>
<td><input class="btn btn-danger" type="reset" value="Clear"></td>

</tr>

</table>
<p style="padding: 5px;">Already Registered ?<a href="Login.jsp">Login</a></p>
</div>
</form>
</div>
<script>
	
	
</script>
</body>
</html>