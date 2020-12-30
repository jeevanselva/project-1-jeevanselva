package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection newConnection;

	public ConnectionFactory() {
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			String url;
			String userName;
			String password;
			url = System.getenv("DB_URL");
			userName = System.getenv("DB_USER");
			password = System.getenv("DB_PASSWORD");
			this.newConnection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static Connection getNewConnection() {
		return newConnection;
	}

}
