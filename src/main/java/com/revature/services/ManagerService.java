package com.revature.services;

import com.revature.models.ListOfReimbursements;
import com.revature.models.Reimbursement;
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

	public void updateReimbursement(Reimbursement reimbursement) {
		dao.updateReimbursementStatus(reimbursement);
	}

}
