package com.revature.services;

import com.revature.models.CurrentUser;
import com.revature.models.UserCredential;
import com.revature.repositories.UserDAO;

public class UserService {
	UserDAO dao;

	public UserService() {
		this.dao = new UserDAO();
	}

	public boolean validateUser(UserCredential user) {
		CurrentUser currentUser = dao.validatUserAndPassword(user);
		if (currentUser.getFirstName() == null) {
			return false;
		} else {
			return true;
		}
	}
}
