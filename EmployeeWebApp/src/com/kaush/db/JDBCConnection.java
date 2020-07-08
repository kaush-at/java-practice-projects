package com.kaush.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	public static Connection getConnection() {
		Connection con = null;		
		String URL = "jdbc:mysql://localhost:3306/employees_database";
		String username = "root";
		String password = "Ruka@123";
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL,username,password);
			if(con != null) {
				return con;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

}
