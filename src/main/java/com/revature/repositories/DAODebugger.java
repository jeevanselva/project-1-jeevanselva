package com.revature.repositories;

import com.revature.models.CurrentUser;
import com.revature.models.ListOfReimbursements;

public class DAODebugger {
	public static void main(String[] args) {

		CurrentUser user = new CurrentUser();
		user.setUserId(2);
		// EmployeeDAO dao = new EmployeeDAO(user);
		ManagerDAO dao = new ManagerDAO();

		ListOfReimbursements list = dao.readEmployeeTickets();

		System.out.println(list.toString());

	}

}
