package com.revature.repositories;

import com.revature.models.CurrentUser;
import com.revature.models.Reimbursement;

public class DAODebugger {
	public static void main(String[] args) {

		CurrentUser user = new CurrentUser();
		user.setUserId(2);
		// EmployeeDAO dao = new EmployeeDAO(user);
		ManagerDAO dao = new ManagerDAO();

		Reimbursement r = new Reimbursement();
		r.setStatus("Test");
		r.setReimbursementId(2);

		dao.updateReimbursementStatus(r);

		// ListOfReimbursements list = dao.readEmployeeReimbursements();

		// System.out.println(list.toString());

	}

}
