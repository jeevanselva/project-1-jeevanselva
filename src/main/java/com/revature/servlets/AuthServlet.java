package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.CurrentUser;
import com.revature.models.UserCredential;
import com.revature.services.UserService;

public class AuthServlet extends HttpServlet {
	ObjectMapper om = new ObjectMapper();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserCredential user = om.readValue(request.getInputStream(), UserCredential.class);
		UserService service = new UserService();
		CurrentUser currentUser = service.validateUser(user);
		response.setStatus(200);
		response.setHeader("Content-Type", "application/json");
		response.getWriter().write(om.writeValueAsString(currentUser));
		System.out.println("This was called!");
	}

}
