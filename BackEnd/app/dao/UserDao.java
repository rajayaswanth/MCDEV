package dao;

import javax.inject.Inject;
import javax.inject.Singleton;

import models.User;

import java.sql.*;
import play.db.*;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class UserDao {
	
	@Inject private Database db;
	
	public List<User>findAll() throws SQLException{
		List<User> userList= new ArrayList<>();
		//String conn= db.getName();
		System.out.println(db);
//		PreparedStatement preparedStatement = conn.prepareStatement("select * from user_master_table;");
//		preparedStatement.executeQuery();
//		ResultSet rs= preparedStatement.getResultSet();
//		while(rs.next())
//		{
//			User user= new User();
//			user.setEmail(rs.getString("email"));
//			user.setName(rs.getString("name"));
//			userList.add(user);
//		}
		return userList;
	}
	
	
}
