<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="margin-left:35%">
		<% if(request.getAttribute("error")!=null){ %>
		<%= request.getAttribute("error") %>
		<%} %>
		<h1>Register</h1>
		<form action="Register" method="post">
		
			<label>Username</label> <br/>
			<input type="text" name="username" id="name"><br/>
			
			<label>Email</label> <br/>
			<input type="text" name="email" id="email"><br/>
			
			<label>Date of Birth</label> <br/>
			<input type="Date" name="dob" id="dob"><br/>
			
			<label>Gender</label> <br/>
			<select name="gender"><br/>
				<option value="male">Male</option>
				<option value="female">Female</option>
			</select><br/>
			
			<label>Address </label><br>
			<textarea rows="5" cols="40" name=address></textarea><br>
			
			<label>Password </label><br>
			<input type="password" name="password" id="password"><br>
			
			<label>Re-enter Password </label><br>
			<input type="password" name="repassword" id="repassword"><br/><br>
			
			<input type="submit" value="Submit" id="submit">
		</form>
		<br>
		Already have an Account? <a href="login">Login</a> 
	</div>
</body>
</html>