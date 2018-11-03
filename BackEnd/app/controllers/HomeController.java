package controllers;

import java.sql.SQLException;
import java.util.List;

import dao.UserDao;
import models.User;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

	UserDao user= new UserDao();
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     * @throws SQLException 
     */
    public Result index() throws SQLException {
    	try
    	{
    		List<User> userList= user.findAll();
    	    return ok(Json.toJson(userList)).as("application/json");
    	}
        catch (SQLException e)
        {
        	throw e;
        }
    }

}
