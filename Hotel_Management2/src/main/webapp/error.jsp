
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<%@ include file="cookies.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
        /* Your custom CSS code here */
        body {
            font-family: 'Arial', sans-serif; /* Use a common font for better compatibility */
            background-color: #f8f9fa; /* Set a light gray background color */
        }

        .container {
            max-width: 400px; /* Set a maximum width for the content */
            margin: 100px auto; /* Center the container */
            text-align: center; /* Center text inside the container */
        }

        h1 {
            color: #dc3545; /* Set the heading color to a red shade */
        }

        p {
            line-height: 1.5; /* Increase line height for better readability */
        }

        a {
            color: #007bff; /* Set link color to a blue shade */
            text-decoration: none; /* Remove underline */
        }

        a:hover {
            text-decoration: underline; /* Add underline on hover */
        }

        /* Add more custom styles as needed */
    </style>
</head>
<body>
<div class="container">
 <h1>Error Page</h1>
    <p>An unexpected error occurred. We apologize for the inconvenience.</p>
    
    <p>Error Message:<%= exception.getMessage() %></p>

   
    
    

    <!-- You can customize the display of exception details based on your needs -->

    <!-- Add a link to go back to the home page or any other appropriate action -->
    <p><a href="index.jsp" class="btn btn-primary">Go to Home</a></p>
</div>
</body>
</html>
