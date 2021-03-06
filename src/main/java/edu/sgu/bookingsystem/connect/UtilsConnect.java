package edu.sgu.bookingsystem.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtilsConnect {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	// url connected to database
	private static final String url = "jdbc:mysql://localhost:3306/bookingbusticketsystem";
	// Database username
	private static final String username = "root";
	// Database password
	private static final String password = "1234";

	private static Connection conn = null;

	// static code block to load drive
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// return database connection object
	public static Connection getConnection() throws Exception {
		if (conn == null) {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conn = UtilsConnect.getConnection();
			if (conn != null) {
				System.out.println("ok");
			} else
				System.out.println("no");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

