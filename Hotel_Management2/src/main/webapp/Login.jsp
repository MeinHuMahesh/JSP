<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="cookies.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" >
</head>
<body>
<div class=" d-flex align-items-center justify-content-center" style="margin: auto;margin-top:10%;width: 60%;height: 100%;border: 3px solid black;padding: 10px;">
<form action="Login" method="post" >
<div class="form-group">
<h3 class="form-text">Login Form</h3>
<table>
<tr>
	<td class="form-text"><b>Email</b></td>
    <td><input class="form-control" type="email" placeholder="Enter Email" name="email" id="email" required></td>
</tr>
<tr>
	<td class="form-text"><b>Password</b></td>
    <td><input class="form-control" type="password" placeholder="Enter Password" name="password" id="password" required></td>
</tr>
<tr>
<td><input class="btn btn-primary" type="submit" value="Login"></td>
<td><input class="btn btn-danger" type="reset" value="Clear"></td>

</tr>
</table>
<p>Not Registered ??? <a  href="register.jsp">Register</a></p>
</div>
</form>
</div>
</body>
</html>