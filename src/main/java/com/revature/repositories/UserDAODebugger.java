package com.revature.repositories;

import com.revature.models.CurrentUser;
import com.revature.models.UserCredential;
import com.revature.services.UserService;

public class UserDAODebugger {
	public static void main(String[] args) {
		UserCredential u = new UserCredential();
		UserService s = new UserService();

		u.setUserName("swoodeson0");
		// u.setUserName("random");
		// u.setPassword("random");
		u.setPassword("j9mSFOzSJ");
		UserDAO dao = new UserDAO();
		CurrentUser cu = dao.validatUserAndPassword(u);

	}

}
