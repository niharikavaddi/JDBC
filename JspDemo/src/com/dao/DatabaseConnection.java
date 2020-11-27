package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public static Connection Connect() {
		Connection connection = null;
		try {
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			String url = "jdbc:mysql://127.0.0.1:3306/mydata?autoReconnect=true&useSSL=false";
			connection = DriverManager.getConnection(url, "niharika", "mysqlpassword");
			System.out.println(connection != null ? "DAO: Connection established" : "DAO: Connection failed");
		} catch (SQLException ep) {
			System.err.println(ep.toString());
		} catch (Exception ep) {
			System.err.println(ep.toString());
		}
		return connection;
	}
}