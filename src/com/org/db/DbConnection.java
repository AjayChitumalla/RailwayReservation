package com.org.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getDbconnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","ajayCh");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver not found !!");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("Connection to DB failed!");
			e.printStackTrace();
		}
		if (connection != null) {
			System.out.println("Connection made to DB!");
		}
		return connection;
	}
	
}
