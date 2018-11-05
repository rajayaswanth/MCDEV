package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.inject.Singleton;

@Singleton
public class DBConnection {
	
	private static DBConnection dbconnection= null;
	public Connection conn;
	
	// Private Constructor 
	private DBConnection() throws SQLException
	{
		conn= (Connection) DriverManager.getConnection("jdbc:mysql://root:password@localhost/sssamc");
	}
	
	// Static method which is being used to instantiate static variable 
	public static DBConnection getConnection() throws SQLException
	{
		if(dbconnection == null)
		{
			dbconnection= new DBConnection();
			return dbconnection;
		}
		else 
			return dbconnection;
	}

}
