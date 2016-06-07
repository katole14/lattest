package com.flp.pms.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Connection;

public class DataBaseRequirements {

	Connection connection = null;
	PreparedStatement preparedStatement = null;

	public Connection getDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ParallelProject", "root", "India123");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public PreparedStatement getPreparedStatement(String sql) {

		try {
			preparedStatement = getDBConnection().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return preparedStatement;
	}
}