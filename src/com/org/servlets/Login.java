package com.org.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.db.ApplicationDao;

@WebServlet(urlPatterns = {"/","/login"})
public class Login extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ApplicationDao dao = new ApplicationDao();
		boolean isValidUser = dao.loginUser(username,password);
		
		if(isValidUser) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
		}
		else {
			request.setAttribute("error", "Invalid credentials, please login again !!!");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	}
}
