package supportiveClasses;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import model.savePayment;
import model.Payment;
import model.User;


public class PaymentHandler 
{
	public ArrayList<Payment> getAllPayment() throws SQLException
	{
		ArrayList<Payment> list = new ArrayList();
		String qry = "SELECT * FROM payment";
		connection c = new connection();
		ResultSet rs = c.getRs(qry);
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss"); 	
			
			while(rs.next())
			{
				Payment p = new Payment();
				p.setPtid(rs.getInt(1));
				p.setPtype(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				Date date = rs.getDate(4);
				p.setDte(dateFormat.format(date));
				
				list.add(p);
			}
			c.con.close();
			return list;
			
	}

	public Payment getPaymentDetails(int id) throws SQLException
	{
		String qry = "SELECT * FROM `payment` WHERE PaymenID = "+id+"";
		connection c = new connection();
		ResultSet rs = c.getRs(qry);
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss"); 
		Payment p = new Payment();
		
		while(rs.next())
		{
			
			p.setPtid(rs.getInt(1));
			p.setPtype(rs.getString(2));
			p.setPrice(rs.getDouble(3));
			Date date = rs.getDate(4);
			p.setDte(dateFormat.format(date));
		}
		c.con.close();
		
		return p;
	}
	
	public String insertPaymentDetails(savePayment p) throws SQLException
	{
		User u = new User();
		u.setUserName(p.getUserName());
		u.setPass(p.getPassword());
		
		if(UserValidation(u))
		{	
			connection c = new connection();
			String sql = "INSERT INTO `payment` (`PaymenType`, `PaymenPrice`) VALUES (?,?)";
			PreparedStatement ps = c.getPs(sql);
			
			ps.setString(1, p.getPtype());
			ps.setDouble(2, p.getPrice());
			
			if(!ps.execute())
			{
				c.con.close();
				return "successfully inserted";
			}
			else
			{
				c.con.close();
				return "insertion unsuccessful";
			}
		
		}
		else
		{
			return "Invalid User";
		}
	}

	public String deletePaymentDetails(int id) throws SQLException
	{
		connection c = new connection();
		String qry = "DELETE FROM `payment` WHERE PaymenID = ?";
		PreparedStatement ps = c.getPs(qry);
		
		ps.setInt(1,id);
		
		if(!ps.execute())
		{
			c.con.close();
			return  "successfully deleted";
		}
		else
		{
			c.con.close();
			return  "unsuccessful deletion";
		}
	}
	
	public String updatePaymentDeails(Payment p)throws SQLException
	{
		connection c = new connection();
		String sql = "update payment set PaymenType = ?, PaymenPrice = ? where PaymenID = ?";
	    PreparedStatement ps = c.getPs(sql);
	    ps.setString(1, p.getPtype());
	    ps.setDouble(2, p.getPrice());
	    ps.setInt(3,p.getPtid());
	    
	    if(!ps.execute())
	    {
			c.con.close();
			return "Successfully Updated";
	    }
	    else
	    {
			c.con.close();
			return "Updation Unsuccessful";
	    }
	}

	private Boolean UserValidation(User u)
	{
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/com.login/user/login/finduser");
		Response response = target.request().post(Entity.json(u));
		
		String rslt = response.readEntity(String.class);
		
		if(rslt.equals("success"))
		{
			return true;
		}
		else 
		{
			return false;
		}
		
		
	}

}
