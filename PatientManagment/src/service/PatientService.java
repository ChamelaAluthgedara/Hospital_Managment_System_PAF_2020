package service;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Patient;
import utill.DBconnection;

public class PatientService {
	
	
	Connection con = null;

	public PatientService() {
		con = DBconnection.connection();
	}

	public String insertPatient(Patient patientOb) {

		String output = "";
		try {

			if (con == null) {
				return " Erro while Connecting to the databse for insering Please check your Database Connection";

			}
			String query = "INSERT INTO patient (PID,FIRST_NAME,LAST_NAME,USER_NAME,AGE,GENDER,EMAIL_ADDRESS,PERMENT_ADDRESS,CONTACT_NO,PASSWORD,CONFIRM_PASSWORD)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setInt(1, patientOb.getPid());
			statement.setString(2, patientOb.getFirstName());
			statement.setString(3, patientOb.getLastName());
			statement.setString(4, patientOb.getUserName());
			statement.setInt(5, patientOb.getAge());
			statement.setString(6, patientOb.getGender());
			statement.setString(7, patientOb.getEmailAddress());
			statement.setString(8, patientOb.getPermenentAddress());
			statement.setInt(9, patientOb.getContactNumber());
			statement.setString(10, patientOb.getPassword());
			statement.setString(11, patientOb.getConfirmPassword());

			// execute statement
			statement.execute();
			con.close();

			output = "Insert Successfull";

		} catch (Exception e) {
			output = "Erro while Inserting the Patient";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String readPatient() {

		String output = "";

		try {

			if (con == null) {
				return " Erro while Connecting to the databse for Reading Please check your Database Connection";
			}

			output = "<table border=\"2\"><tr><th>First Name</th><th>Last Name </th><th>User Name</th><th>Age</th><th>Gender"
					+ "</th><th>Email Address</th><th>Permenent Address</th><th>Contact Number</th><th>Password</th><th>Confirm Pasword</th></tr>";

			String query = "SELECT * FROM patient";
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				String pid = Integer.toString(rs.getInt("PID"));
				String firtname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				String UserName = rs.getString("USER_NAME");
				String age = Integer.toString(rs.getInt("AGE"));
				String gender = rs.getString("GENDER");
				String emailAddress = rs.getString("EMAIL_ADDRESS");
				String PermentAddress = rs.getString("PERMENT_ADDRESS");
				String ContactNumber = Integer.toString(rs.getInt("CONTACT_NO"));
				String Password = rs.getString("PASSWORD");
				String confpassword = rs.getString("CONFIRM_PASSWORD");

				// Add into html table

				output += "<tr><td>" + firtname + "</td>";
				output += "<td>" + lastname + "</td>";
				output += "<td>" + UserName + "</td>";
				output += "<td>" + age + "</td>";
				output += "<td>" + gender + "</td>";
				output += "<td>" + emailAddress + "</td>";
				output += "<td>" + PermentAddress + "</td>";
				output += "<td>" + ContactNumber + "</td>";
				output += "<td>" + Password + "</td>";
				output += "<td>" + confpassword + "</td>";

				// AddButton

				output += "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"items.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">"
						+ "<input name=\"itemID\" type=\"hidden\" value=\"" + pid + "\">" + "</form></td></tr>";

			}

			con.close();

			output += "</table>";

		} catch (Exception e) {
			// TODO: handle exception

			output = "erro while reading patient";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String UpdatePatient(Patient patientOb) {

		String output = "";

		try {

			if (con == null) {
				return " Erro while Connecting to the databse for updating Please check your Database Connection";
			}

			String query = "UPDATE patient SET FIRST_NAME = ?,LAST_NAME = ?,USER_NAME = ?,AGE = ?,GENDER = ?,EMAIL_ADDRESS = ?,PERMENT_ADDRESS = ?,CONTACT_NO = ?,PASSWORD = ?,CONFIRM_PASSWORD = ?  WHERE PID = ?";

			PreparedStatement statement = con.prepareStatement(query);

			statement.setString(1, patientOb.getFirstName());
			statement.setString(2, patientOb.getLastName());
			statement.setString(3, patientOb.getUserName());
			statement.setInt(4, patientOb.getAge());
			statement.setString(5, patientOb.getGender());
			statement.setString(6, patientOb.getEmailAddress());
			statement.setString(7, patientOb.getPermenentAddress());
			statement.setInt(8, patientOb.getContactNumber());
			statement.setString(9, patientOb.getPassword());
			statement.setString(10, patientOb.getConfirmPassword());
			statement.setInt(11, patientOb.getPid());

			statement.execute();
			con.close();

			output = "Update Sucess";

		} catch (Exception e) {
			// TODO: handle exception
			output = "Error while updating patient.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String Deletepatient(int Pid) {

		String output = "";

		try {

			if (con == null) {
				return " Erro while Connecting to the databse for Deleting Please check your Database Connection";
			}

			String query = "DELETE FROM patient WHERE PID = ? ";

			PreparedStatement statment = con.prepareStatement(query);

			statment.setInt(1, Pid);

			statment.execute();
			con.close();

			output = "Delete Successs";

		} catch (Exception e) {
			// TODO: handle exception

			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}

		return output;

	}

}
