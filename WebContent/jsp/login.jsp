<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="margin-left:35%;">
		<% if(request.getAttribute("error")!=null){ %>
		<%= request.getAttribute("error") %>
		<%} %>
		<h1>Login</h1>
		<form action="Login" method="post">
		
			<label>Username</label> <br/>
			<input type="text" name="username" id="name"><br/>
			
			<label>Password </label><br>
			<input type="password" name="password" id="password"><br><br>
			
			<input type="submit" value="Submit" id="submit">
		</form>
		<br>
		Don't have an Account? <a href="register">Register</a>
</body>
</html>