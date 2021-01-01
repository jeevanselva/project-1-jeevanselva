package com.revature.repositories;

import com.revature.models.ReimbursementSubmission;
import com.revature.services.EmployeeService;

public class DAODebugger {
	public static void main(String[] args) {
		/*
		 * CurrentUser user = new CurrentUser(); user.setUserId(2); // EmployeeDAO dao =
		 * new EmployeeDAO(user); ManagerDAO dao = new ManagerDAO();
		 * 
		 * Reimbursement r = new Reimbursement(); r.setStatus("Test");
		 * r.setReimbursementId(2);
		 * 
		 * dao.updateReimbursementStatus(r);
		 * 
		 * // ListOfReimbursements list = dao.readEmployeeReimbursements();
		 * 
		 * // System.out.println(list.toString());
		 */

		ReimbursementSubmission r = new ReimbursementSubmission();

		r.setAuthorId(2);
		r.setAmount(500);
		r.setDescription("Took the bus");
		r.setType("Lodging");

		EmployeeService service = new EmployeeService();
		service.submitReimbursement(r);

	}

}
