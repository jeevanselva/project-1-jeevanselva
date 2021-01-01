package com.revature.services;

import com.revature.models.CurrentUser;
import com.revature.models.ListOfReimbursements;
import com.revature.models.ReimbursementSubmission;
import com.revature.repositories.EmployeeDAO;

public class EmployeeService {
	EmployeeDAO dao;

	public EmployeeService(CurrentUser user) {
		this.dao = new EmployeeDAO(user);
	}

	public EmployeeService() {
		this.dao = new EmployeeDAO();
	}

	public ListOfReimbursements getPastReimbursements() {
		ListOfReimbursements r = dao.readAllReimbursements();
		return r;
	}

	public void submitReimbursement(ReimbursementSubmission r) {
		dao.newReimbursement(r);
	}

}
