<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entity.User" %> 
<%@ page import="DatabaseConnection.DatabaseConnection" %>
<%@ page import="DAO.UserDAO" %>
<%@include file="cookies.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <style type="text/css">
  body {
            /* Set background image */
            background-image: url('images/hotel.jpg');
            /* Adjust background properties as needed */
            background-repeat: no-repeat;
            
           background-size: 1600px 1500px; /* or 'contain' based on your preference */
            background-position: center center;
            /* Set a background color as a fallback or for transparency */
            background-color: #f0f0f0;
            /* Adjust other styles as needed */
            margin: 0;
            padding: 0;
            
        }
  
  </style>
</head>
<body>


<h1 style="padding: 20px;color: white;">Welcome <%= userSessionname %> !!!</h1>

</body>
</html>