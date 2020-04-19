package API;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.*;
import supportiveClasses.UserHandler;

@Path("login")
public class PatientResource 
{
	
	@POST
	@Path("finduser")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public String userlogin(User u) throws SQLException 
	{
		UserHandler handler = new UserHandler(u);
		String result = handler.result;
		
		return result;
	}
	
	
	
	
}
