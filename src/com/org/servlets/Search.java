package com.org.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.bean.Train;
import com.org.db.ApplicationDao;

@WebServlet("/checkAvailability")
public class Search extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		if(source.equals("-") ||destination.equals("-")) {
			request.setAttribute("error", "Please select both source and destination points!!!");
			request.getRequestDispatcher("/jsp/booking.jsp").forward(request, response);
		}
		else {
			ApplicationDao dao = new ApplicationDao();
			List<Train> trains = dao.searchTrains(source,destination);
			if(trains.isEmpty()==true) {
				request.setAttribute("error", "Sorry, No trains available for the selected places");
				request.getRequestDispatcher("/jsp/booking.jsp").forward(request, response);
			}
			else {
				request.setAttribute("trains", trains);
				request.getRequestDispatcher("/jsp/selectTrain.jsp").forward(request, response);
			}
		}
	}
}
