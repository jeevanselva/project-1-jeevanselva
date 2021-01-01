package com.revature.services;

import com.revature.models.ListOfReimbursements;
import com.revature.models.Resolved;
import com.revature.repositories.ManagerDAO;

public class ManagerService {
	ManagerDAO dao;

	public ManagerService() {
		this.dao = new ManagerDAO();
	}

	public ListOfReimbursements getAllReimbursements() {
		ListOfReimbursements list = dao.readEmployeeReimbursements();
		return list;
	}

	public void resolveReimbursement(Resolved reimbursement) {
		dao.updateReimbursementStatus(reimbursement);
	}

}
