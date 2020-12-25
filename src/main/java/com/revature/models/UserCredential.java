package com.revature.models;

public class UserCredential {
	private String userName;
	private String password;

	public UserCredential() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserCredential [userName=" + userName + ", password=" + password + "]";
	}

}
