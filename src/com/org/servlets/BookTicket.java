package com.org.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.db.ApplicationDao;

@WebServlet("/bookTicket")
public class BookTicket extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no_of_seats=0;
		String selectedClass = request.getParameter("class");
		if(request.getParameter("no_of_seats")!="") {
			no_of_seats = Integer.parseInt(request.getParameter("no_of_seats"));
		}
		if(no_of_seats == 0 || selectedClass.equals("-")) {
			request.setAttribute("error", "Please fill all details");
			request.getRequestDispatcher("/jsp/bookTicket.jsp").forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			int train_no = Integer.parseInt(request.getParameter("train_no"));
			int train_fare = Integer.parseInt(request.getParameter("train_fare"));
			ApplicationDao dao = new ApplicationDao();
			int isGenerated	= dao.generateTicket(username,train_no,no_of_seats,selectedClass,train_fare);
			if(isGenerated==0) {
				request.setAttribute("error", "Some error occured");
				request.getRequestDispatcher("/jsp/bookTicket.jsp").forward(request, response);
			}
			else {
				request.setAttribute("error", "Successfully booked the ticket !!");
				request.getRequestDispatcher("/showTickets").forward(request, response);
			}
		}
	}
}
