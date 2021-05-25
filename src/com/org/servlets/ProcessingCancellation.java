package com.org.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.db.ApplicationDao;

@WebServlet("/ProcessingCancellation")
public class ProcessingCancellation extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int ticket_no = Integer.parseInt(request.getParameter("ticket_no"));
		System.out.print(ticket_no);
		ApplicationDao dao = new ApplicationDao();
		int result = dao.removeTicket(ticket_no);
		if(result == 1) {
			request.setAttribute("error", "Successfully cancelled the ticket !!");
			request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
		}
		else {
			request.setAttribute("error", "Some error occurred !!");
			request.getRequestDispatcher("/jsp/cancelTicket.jsp").forward(request, response);
		}
	}
}
