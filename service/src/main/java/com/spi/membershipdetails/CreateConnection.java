package com.spi.membershipdetails;

import java.sql.*;

public class CreateConnection {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Sattapanchayat";
	//"jdbc:mysql://hostname:port/dbname","username", "password"
	static final String USER = "root";
	static final String PASS = "root";
	
	 /*
	//Live
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/sattapan_membership";
	//"jdbc:mysql://hostname:port/dbname","username", "password"
	final String USER = "sattapan_root";
	final String PASS = "J4OHh@.ud$";
 */
	
	public Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
