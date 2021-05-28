<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="com.org.bean.Ticket" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancel Ticket</title>
<style>
table,tr,td,th{
	border:1px solid black;
	border-collapse: collapse;
	padding:20px
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<a href="home" style="margin-left: 10%">Go to Home</a>
	<a href="logout" style="float: right;margin-right: 10%">Logout</a>
	<div style="margin-left: 25%">
	<h1>Your Tickets</h1>
	<div style="margin-left: 25%">
		<% if(request.getAttribute("error")!=null){ %>
			<%= request.getAttribute("error") %>
		<%} %>
	</div>
	<div>
		<table>
			<tr>
				<th>Ticket No</th>
				<th>UserName</th>
				<th>Train No</th>
				<th>No of seats</th>
				<th>class</th>
				<th>Price</th>
				<th>Cancel</th>
			</tr>
		<% 	List<Ticket> tickets = (List)session.getAttribute("tickets");
			for(int i=0;i<tickets.size();i++){ %>
			<tr>
				<form action="ProcessingCancellation" method="post">
					<td><%= tickets.get(i).getTicket_no() %></td>
					<td><%= tickets.get(i).getUsername() %></td>
					<td><%= tickets.get(i).getTrain_no() %></td>
					<td><%= tickets.get(i).getNo_of_seats() %></td>
					<td><%= tickets.get(i).getclass() %></td>
					<td><%= tickets.get(i).getPrice() %></td>
					<input type="hidden" name="ticket_no" value=<%= tickets.get(i).getTicket_no() %>>
					<td><button>Cancel Ticket</button></td>
				</form>
			</tr>
		<%} %>
		</table>
	</div>
</body>
</html>