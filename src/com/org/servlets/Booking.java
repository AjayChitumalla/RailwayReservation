package com.org.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.db.ApplicationDao;

@WebServlet("/booking")
public class Booking extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ApplicationDao dao = new ApplicationDao();
		List<String> places = dao.getSourceDestination();
		HashSet<String> sources = new HashSet<>();
		HashSet<String> destinations = new HashSet<>();
		for(int i=0;i<places.size();i++) {
			if(i%2==0) {
				sources.add(places.get(i));
			}
			if(i%2!=0) {
				destinations.add(places.get(i));
			}
		}
		HttpSession session = request.getSession();
		session.setAttribute("sources", sources);
		session.setAttribute("destinations", destinations);
		request.getRequestDispatcher("/jsp/booking.jsp").forward(request, response); 
	}
}
