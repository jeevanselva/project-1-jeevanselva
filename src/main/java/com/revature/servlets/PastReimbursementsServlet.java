package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.CurrentUser;
import com.revature.models.ListOfReimbursements;
import com.revature.services.EmployeeService;

public class PastReimbursementsServlet extends HttpServlet {
	ObjectMapper om = new ObjectMapper();

	public PastReimbursementsServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CurrentUser user = om.readValue(request.getInputStream(), CurrentUser.class);
		EmployeeService service = new EmployeeService(user);
		ListOfReimbursements list = service.getPastReimbursements();
		response.setStatus(200);
		response.setHeader("Content-Type", "application/json");
		response.getWriter().write(om.writeValueAsString(list));
	}

}
