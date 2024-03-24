package com.crud.Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig {

	public static Connection getConnection() {

		Connection con = null;

		final String url = "jdbc:mysql://localhost:3306/chandandb";
		final String usr = "root";
		final String pass = "govt";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, usr, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
///This class is basically responsible for database connection...