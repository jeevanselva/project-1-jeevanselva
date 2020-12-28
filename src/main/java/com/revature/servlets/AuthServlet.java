package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.UserCredential;
import com.revature.services.UserService;

public class AuthServlet extends HttpServlet {
	ObjectMapper om = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/login.html");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserCredential user = om.readValue(request.getInputStream(), UserCredential.class);
		UserService service = new UserService();
		boolean validated = service.validateUser(user);
		HttpSession session = request.getSession();
		if (validated == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/login.html");
		}

	}
}
