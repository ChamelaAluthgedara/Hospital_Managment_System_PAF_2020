package supportiveClasses;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;

public class UserHandler 
{
	
	public String result = "";
	public UserHandler(User user) throws SQLException
	{
		String un = user.getUserName();
		String pw = user.getPass();

		String qry = "select * from patient where USER_NAME = '"+un+"' AND password = '"+pw+"';";
		connection c = new connection();
		ResultSet rs = c.getRs(qry);
		
		if(rs.first())
		{
			c.con.close();
			result =  "success";
		}
		else
		{	c.con.close();
			result = "unsuccessful";
		}


		
	}

	
}
