package com.revature.repositories;

import com.revature.models.CurrentUser;
import com.revature.models.UserCredential;

public class UserDAODebugger {
	public static void main(String[] args) {
		UserCredential u = new UserCredential();
		u.setUserName("swoodeson0");
		u.setPassword("j9mSFOzSJ");
		UserDAO dao = new UserDAO();
		CurrentUser cu = dao.validatUserAndPassword(u);
		System.out.println(cu);
	}

}
