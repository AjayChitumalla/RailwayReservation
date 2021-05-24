package com.org.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.bean.Train;
import com.org.db.ApplicationDao;

@WebServlet("/selectTrain")
public class selectTrain  extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationDao dao = new ApplicationDao();
		Train selectedTrain = dao.getTrainById(request.getParameter("id"));
		HttpSession session = request.getSession();
		session.setAttribute("selectedTrain", selectedTrain);
		request.getRequestDispatcher("/jsp/bookTicket.jsp").forward(request, response);
	}
}
