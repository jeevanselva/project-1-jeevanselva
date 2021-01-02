package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Resolved;
import com.revature.services.ManagerService;

public class ResolveReimbursementServlet extends HttpServlet {
	ObjectMapper om = new ObjectMapper();

	public ResolveReimbursementServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ManagerService service = new ManagerService();
		Resolved reimbursement = om.readValue(request.getInputStream(), Resolved.class);
		service.resolveReimbursement(reimbursement);
		response.setStatus(200);
	}

}
