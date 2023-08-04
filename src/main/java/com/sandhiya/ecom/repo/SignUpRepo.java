package com.sandhiya.ecom.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SignUpRepo {
	
	public boolean insertUserDetails(String name,String email,String password) {
		
		try {
			Connection con=JdbcConnection.getDbConnection();
			String insertQuery="insert into users (name,email,password) values(?,?,?)";
			PreparedStatement ps =con.prepareStatement(insertQuery);
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			
			int result =ps.executeUpdate();
			
			return result==1;
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		return false;

}
}
