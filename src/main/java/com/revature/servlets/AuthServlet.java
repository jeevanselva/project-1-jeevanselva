package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.CurrentUser;
import com.revature.models.UserCredential;
import com.revature.services.UserService;

public class AuthServlet extends HttpServlet {
	ObjectMapper om = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserCredential user = om.readValue(request.getInputStream(), UserCredential.class);
		UserService service = new UserService();
		CurrentUser currentUser = service.validateUser(user);
		HttpSession session = request.getSession();
		if (currentUser.isValidated()) {
			response.getWriter().write(om.writeValueAsString(currentUser));
			response.setHeader("Content-Type", "application/json");
			response.setStatus(303);
			response.setHeader("Location", request.getContextPath() + "/employee.html");
			response.sendRedirect("employee");
		} else {

			response.sendRedirect("login");
		}

	}
}
