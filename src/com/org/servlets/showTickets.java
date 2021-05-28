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

@WebServlet("/showTickets")
public class showTickets extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Ticket> tickets;
		ApplicationDao dao = new ApplicationDao();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		tickets = dao.getTickets(username);
		session.setAttribute("tickets", tickets);
		System.out.print(username+tickets);
		request.getRequestDispatcher("/jsp/showTickets.jsp").forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
}
