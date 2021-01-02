package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ListOfReimbursements;
import com.revature.models.Resolved;
import com.revature.services.ManagerService;

public class AllReimbursementServlet extends HttpServlet {
	ObjectMapper om;

	public AllReimbursementServlet() {
		super();
		this.om = new ObjectMapper();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ManagerService service = new ManagerService();
		ListOfReimbursements list = service.getAllReimbursements();
		response.setStatus(200);
		response.setHeader("Content-Type", "application/json");
		response.getWriter().write(om.writeValueAsString(list));
	}



}
