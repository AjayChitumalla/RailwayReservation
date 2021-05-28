<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.org.bean.Train" %>>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Details</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<a href="home" style="margin-left: 10%">Go to Home</a>
	<a href="logout" style="float: right;margin-right: 10%">Logout</a>
	<h1 style="margin-left: 30%">Fill Your Details</h1>
	<% if(request.getAttribute("error")!=null){ %>
		<div style="margin-left: 30%"><%= request.getAttribute("error") %></div>
	<%} %>
	<% Train train = (Train)(session.getAttribute("selectedTrain")); %>
	<form style="border: 1px solid red;max-width: 35%;max-height: 300px;margin-left: 25%" action="bookTicket" method="post">
		<%= train.getTrain_no() %>
		<span style="float: right"><b><%=train.getTrain_name() %></b></span><br>
		<span style="margin-left: 25%"><b><%=train.getSource_point() %> ---> <%=train.getDestination_point() %></b></span><span style="float: right">Date : <%=train.getDate() %></span><br>
		<span>Starts at : <%=train.getStart_time() %> </span><span style="float: right">Reaches at : <%=train.getReach_time() %></span>
		<div style="margin-left: 25%">Available seats : <%=train.getAvailable_seats() %> </div>
		<span style="margin-left: 30%">Fare : Rs.<b><%=train.getFare() %>.00</b></span><br>
		<label>Number of seats : </label>
		<input type="number" name="no_of_seats" style="width:80px" ><br>
		<label>Select the class   : </label>
		<select name="class" style="width:90px">
		<option value="-">-</option>
		<option value="First class">First class</option>
		<option value="Economy">Economy</option>
		<option value="Sleeper">Sleeper</option>
		</select><br>
		<input type="hidden" name="train_no" value=<%= train.getTrain_no() %>>
		<input type="hidden" name="train_fare" value=<%= train.getFare() %>>
		<button style="float: right">Book Ticket</button>
	</form><br>
</body>
</html>