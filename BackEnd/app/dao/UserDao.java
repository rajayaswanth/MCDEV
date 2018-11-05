package dao;

import javax.inject.Singleton;

import models.User;

import java.sql.*;
import utility.DBConnection;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class UserDao {
	 
	
	public List<User>findAll() throws SQLException{
		List<User> userList= new ArrayList<>();
		DBConnection dbconnection= DBConnection.getConnection();
		PreparedStatement preparedStatement = dbconnection.conn.prepareStatement("select * from user_master_table;");
		preparedStatement.executeQuery();
		ResultSet rs= preparedStatement.getResultSet();
		while(!rs.next());
		{
			User user= new User();
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			user.setMobile(rs.getString("mobile"));
			user.setUser_id(rs.getInt("user_id"));
			user.setRole(rs.getInt("role"));
			user.setStatus(rs.getInt("status"));
			user.setValidated(rs.getBoolean("validated"));
			userList.add(user);
		}
		return userList;
	}
	
	
}
