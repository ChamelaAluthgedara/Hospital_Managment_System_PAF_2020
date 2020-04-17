package model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Patient {

	//Method for the connect to DB
	
	private Connection connection() {
		
		Connection con = null ;
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//DB Connection
					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/patient", "root" , "pasindupasi1998");
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return con;
	}
	
	public String insertPatient(String firstName , String lastName , String UserName , int age , String gender , String Email_Address , String PermenentAddress,
			String Password , String ConfirmPassword) {
		
		String output = "";
		try {
			
			Connection con = connection();
			
			if(con == null) {
				return " Erro while Connecting to the databse for insering Patient Please check your Database Connection";
				
			}
			String query = "INSERT INTO patient (PID,FIRST_NAME,LAST_NAME,USER_NAME,AGE,GENDER,EMAIL_ADDRESS,PERMENT_ADDRESS,PASSWORD,CONFIRM_PASSWORD)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?)" ; 
			
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setInt(1, 5);
			statement.setString(2, firstName);
			statement.setString(3, lastName);
			statement.setString(4, UserName);
			statement.setInt(5, age);
			statement.setString(6, gender);
			statement.setString(7, Email_Address);
			statement.setString(8, PermenentAddress);
			statement.setString(9, Password);
			statement.setString(10, ConfirmPassword);
			
			//execute statement
			statement.execute();
			con.close();
			
			output = "Insert Successfull";
					
		}
		catch (Exception e) {
			output = "Erro while Inserting the Patient";
			System.err.println(e.getMessage());
		}
		
		
		return output;
	}
	
	
	public String readPatient() {
		
		String output = "";
		
		try {
			
			Connection con = connection();
			
			if(con == null) {
				return " Erro while Connecting to the databse for Reading Patient Please check your Database Connection";
			}
			
			output = "<table border=\"2\"><tr><th>First Name</th><th>Last Name </th><th>User Name</th><th>Age</th><th>Gender"
					+ "</th><th>Email Address</th><th>Permenent Address</th><th>Password</th><th>Confirm Pasword</th></tr>";
			
			String query = "SELECT * FROM patient";
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				String pid = Integer.toString(rs.getInt("PID"));
				String firtname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				String UserName = rs.getString("USER_NAME");
				String age = Integer.toString(rs.getInt("AGE"));
				String gender = rs.getString("GENDER");
				String emailAddress = rs.getString("EMAIL_ADDRESS");
				String PermentAddress = rs.getString("PERMENT_ADDRESS");
				String Password = rs.getString("PASSWORD");
				String confpassword = rs.getString("CONFIRM_PASSWORD");
				
				//Add into html table
				
				output += "<tr><td>" + firtname + "</td>";
				output += "<td>" + lastname + "</td>";
				output += "<td>" + UserName + "</td>";
				output += "<td>" + age + "</td>" ;
				output += "<td>" + gender + "</td>";
				output += "<td>" + emailAddress + "</td>";
				output += "<td>" + PermentAddress + "</td>";
				output += "<td>" + Password + "</td>";
				output += "<td>" + confpassword + "</td>";
				
				
				//AddButton
				
				output += "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>"
						 + "<td><form method=\"post\" action=\"items.jsp\">"
						 + "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">"
						 + "<input name=\"itemID\" type=\"hidden\" value=\"" + pid
						 + "\">" + "</form></td></tr>"; 
				
						
				
			}
			
			con.close();
			
			output += "</table>" ;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			output = "erro while reading patient";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	
	public String UpdatePatient(String PId ,String firstName , String lastName , String UserName , String age , String gender , String Email_Address , String PermenentAddress,
			String Password , String ConfirmPassword) {
		
		String output = "" ;
		
		try {
			
			Connection con = connection();
			if(con == null) {
				return " Erro while Connecting to the databse for updating Patient Please check your Database Connection";
			}
			
			String query = "UPDATE patient SET FIRST_NAME = ?,LAST_NAME = ?,USER_NAME = ?,AGE = ?,GENDER = ?,EMAIL_ADDRESS = ?,PERMENT_ADDRESS = ?,PASSWORD = ?,CONFIRM_PASSWORD = ?  WHERE PID = ?";
			
			
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, UserName);
			statement.setInt(4, Integer.parseInt(age));
			statement.setString(5, gender);
			statement.setString(6, Email_Address);
			statement.setString(7, PermenentAddress);
			statement.setString(8, Password);
			statement.setString(9, ConfirmPassword);
			statement.setInt(10, Integer.parseInt(PId));
			
			statement.execute();
			con.close();
			
			output = "Update Sucess" ;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			output = "Error while updating patient.";
			System.err.println(e.getMessage()); 
		}
		
		
		
		return output;
	}
	
	
	public String Deletepatient(String Pid) {
		
		String output = "";
		
		
		try {

			Connection con = connection();
			if(con == null) {
				return " Erro while Connecting to the databse for Deleting Please check your Database Connection";
			}
			
			String query = "DELETE FROM patient WHERE PID = ? ";
			
			PreparedStatement statment = con.prepareStatement(query);
			
			statment.setInt(1, Integer.parseInt(Pid));
			
			statment.execute();
			con.close();
			
			output = "Delete Successs" ;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			output = "Error while deleting the item.";
			System.err.println(e.getMessage()); 
		}
		
		return output;
		
	}
	
	
}
