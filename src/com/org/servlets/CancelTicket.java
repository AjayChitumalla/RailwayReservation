package com.org.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.bean.Ticket;
import com.org.db.ApplicationDao;

@WebServlet("/cancelTicket")
public class CancelTicket extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		ApplicationDao dao =new ApplicationDao();
		List<Ticket> tickets = dao.getTickets(username);
		session.setAttribute("tickets", tickets);
		request.getRequestDispatcher("/jsp/cancelTicket.jsp").forward(request, response);
	}
}
