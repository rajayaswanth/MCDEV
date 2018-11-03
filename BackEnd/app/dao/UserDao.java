package dao;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;

import models.User;

import java.sql.*;
import play.api.db.*;
import play.db.Database;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class UserDao {
	
	@Inject Database db;
	
	public List<User>findAll() throws SQLException{
		Connection conn= DriverManager.getConnection("jdbc:mysql://root:password@localhost/sssamc");
		List<User> userList= new ArrayList<>();
		PreparedStatement preparedStatement = conn.prepareStatement("select * from user_master_table;");
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
