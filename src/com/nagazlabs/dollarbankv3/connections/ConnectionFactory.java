package com.nagazlabs.dollarbankv3.connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static final String URL = "jdbc:mysql://localhost:3306/dollarbank?useSSL=false";
	public static final String USER = "root";
	public static final String PASS = "root";
	
	public static Connection getConnection( ) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			System.out.println("Error connecting to DB");
			e.printStackTrace();
		}
		
		return null;
	}
}
