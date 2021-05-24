<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*" %>
 <%@ page import="com.org.bean.Train" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Train</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<a href="home" style="margin-left: 10%">Go to Home</a>
	<a href="logout" style="float: right;margin-right: 10%">Logout</a>
	<div style="margin-left: 35%">
	<h1>Select a Train</h1>
	<div>
		<% 	List<Train> trains = (List)request.getAttribute("trains"); 
			for(int i=0;i<trains.size();i++){ %>
				<form style="border: 1px solid red;max-width: 45%;max-height: 300px" action="selectTrain" method="post">
					<%= trains.get(i).getTrain_no() %>
					<span style="float: right"><b><%=trains.get(i).getTrain_name() %></b></span><br>
					<span style="margin-left: 25%"><b><%=trains.get(i).getSource_point() %> ---> <%=trains.get(i).getDestination_point() %></b></span><span style="float: right">Date : <%=trains.get(i).getDate() %></span><br>
					<span>Starts at : <%=trains.get(i).getStart_time() %> </span><span style="float: right">Reaches at : <%=trains.get(i).getReach_time() %></span>
					<div style="margin-left: 25%">Available seats : <%=trains.get(i).getAvailable_seats() %> </div>
					<span style="margin-left: 30%">Fare : Rs.<b><%=trains.get(i).getFare() %>.00</b></span>
					<input type="hidden" name="id" value=<%= trains.get(i).getTrain_no()%>>
					<button style="float: right">Book Ticket</button>
				</form><br>
		<%} %>
	</div>
</body>
</html>