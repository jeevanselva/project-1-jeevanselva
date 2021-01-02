package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ReimbursementSubmission;
import com.revature.services.EmployeeService;

public class SubmitReimbursementServlet extends HttpServlet {
	ObjectMapper om = new ObjectMapper();

	public SubmitReimbursementServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeService service = new EmployeeService();
		ObjectMapper om = new ObjectMapper();
		ReimbursementSubmission r = om.readValue(request.getInputStream(), ReimbursementSubmission.class);
		service.submitReimbursement(r);
		response.setStatus(200);
		response.setHeader("Content-Type", "application/json");
		response.getWriter().write(om.writeValueAsString(r));
	}

}
