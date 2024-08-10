<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ include file="cookies.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
        /* Optional: Add custom styles here */
        body {
            background-color: #f8f9fa; /* Set background color to a light gray shade */
            /* Add some padding for better spacing */
        }
        .logout-container {
            max-width: 400px; /* Set a maximum width for the container */
            margin: auto; /* Center the container */
            text-align: center; /* Center text inside the container */
            margin-top: 100px; /* Add some top margin for better positioning */
        }
    </style>
<body>
<%
  session = request.getSession();
  if(session != null){
	  session.invalidate();
  }
%>
<div class="container logout-container">
    <div class="alert alert-info" role="alert">
        <h2 class="alert-heading">Do you really want to Logout !!!!!</h2>
        <p><a href="Login.jsp" class="btn btn-danger">Log Out</a></p>
    </div>
</div>
</body>
</html>