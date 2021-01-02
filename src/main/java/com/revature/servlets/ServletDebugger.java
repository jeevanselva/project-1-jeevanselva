package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.CurrentUser;

public class ServletDebugger extends HttpServlet {
	ObjectMapper om = new ObjectMapper();

	public ServletDebugger() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CurrentUser user = new CurrentUser(2, "Jeevan", "Selva", "manager");
		CurrentUser user2 = new CurrentUser(2, "Jay", "Silva", "employee");
		response.setHeader("Content-Type", "application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().write(om.writeValueAsString(user));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CurrentUser user = new CurrentUser(2, "Jeevan", "Selva", "manager");
		response.setHeader("Content-Type", "application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().write(om.writeValueAsString(user));
		response.setHeader("Location", "/login");
		response.sendRedirect("/login");
	}

}
