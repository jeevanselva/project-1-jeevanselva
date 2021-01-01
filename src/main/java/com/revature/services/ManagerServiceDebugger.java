package com.revature.services;

import com.revature.models.Resolved;

public class ManagerServiceDebugger {

	public static void main(String[] args) {
		ManagerService service = new ManagerService();

		Resolved r = new Resolved();
		r.setReimbursementId(2);
		r.setResolverId(1);
		r.setStatus("Declined");

		service.resolveReimbursement(r);
	}

}
