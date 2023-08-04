package com.sandhiya.ecom.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/shopping-cart";		
		Connection connection= DriverManager.getConnection(url, "root", "root");	
		if(connection !=null) {
			//System.out.println("Connection success");
			
		}	
		return connection;
	}

}
