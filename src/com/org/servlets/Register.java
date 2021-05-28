package com.org.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.bean.User;
import com.org.db.ApplicationDao;

public class Register extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/jsp/Register.jsp").forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
		
		if(password.equals(repassword) && !password.isEmpty()) {
			User user = new User();
			user.setName(request.getParameter("username"));
			user.setEmail(request.getParameter("email"));
			try {
				String dob = request.getParameter("dob");
				user.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(dob));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			user.setGender(request.getParameter("gender"));
			user.setAddress(request.getParameter("address"));
			user.setPassword(password);
			System.out.print(user.toString());
			ApplicationDao dao = new ApplicationDao();
			int isRegistered = dao.registerUser(user);
			if(isRegistered == 0) {
				request.setAttribute("error", "An error occurred !!");
				request.getRequestDispatcher("/jsp/Register.jsp").forward(request, response);
			}
			else {
				request.setAttribute("error", "Registered successfully,Please Login !!!");
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("error", "both the passwords should match and password should not be empty");
			request.getRequestDispatcher("/jsp/Register.jsp").forward(request, response);
		}
	}
}
