package repo;
import java.util.ArrayList;
import java.util.List;

import javax.json.bind.Jsonb;

import models.Hospital;

import java.sql.*;

public class HospitalRepo {
	
	Connection conn = null;
	
	public HospitalRepo() {
	
		String url = "jdbc:mysql://localhost:3306/pafhospitalmanagementdb2020?autoReconnect=true&useSSL=false";
		String userName = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("DB Connected..");
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Faild DB..");
		}
	}
		
		
		
	public List<Hospital> getAllHospitals(){
		
		List<Hospital> hosList = new ArrayList<Hospital>();
		
		String QUERY = "SELECT * FROM Hospitals"; 
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(QUERY);
			
			while( rs.next() ) {
				Hospital hos = new Hospital();
				
				hos.setHospitalId( rs.getInt(1) );
				hos.setHospitalName( rs.getString(2) );
				hos.setAddress( rs.getString(3) );
				hos.setContNum( rs.getInt(4) );
				hos.setCharge( rs.getDouble(5) );
				
				hosList.add(hos); // Adding hospital objects
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		return hosList;
		
		
	}
	
	
	
	public Hospital getHospital(int id){ // Returns a specific object
		Hospital hospital = new Hospital();
	
		String QUERY = "SELECT * FROM Hospitals WHERE hostId = " + id;
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(QUERY);
			
			if( rs.next() ) {
				
				
				hospital.setHospitalId( rs.getInt(1) );
				hospital.setHospitalName( rs.getString(2) );
				hospital.setAddress( rs.getString(3) );
				hospital.setContNum( rs.getInt(4) );
				hospital.setCharge( rs.getDouble(5) );
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return hospital;
	}
	
	
	
	public boolean addHospital(Hospital hospital) {
		boolean retVal = false;
		
		String QUERY = "INSERT INTO Hospitals VALUES(?,?,?,?,?)";
		
		
		try {
			PreparedStatement st = conn.prepareStatement(QUERY);
			
			st.setInt(1, hospital.getHospitalId() );
			st.setString(2, hospital.getHospitalName());
			st.setString(3,  hospital.getAddress());
			st.setInt(4, hospital.getContNum());
			st.setDouble(5,  hospital.getCharge() );
			
			st.executeUpdate();
			retVal = true;
			
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return retVal;
	}
	
	
	
	public boolean updateHospital(Hospital hospital) {
		boolean retVal = false;
		String QUERY = "UPDATE Hospitals SET hosName = ?, address = ?, contNum = ?, hosCharges = ? where  hostId = ?";
		
		try {
			PreparedStatement st = conn.prepareStatement(QUERY);
			
			st.setString(1, hospital.getHospitalName());
			st.setString(2, hospital.getAddress());
			st.setInt(3, hospital.getContNum());
			st.setDouble(4, hospital.getCharge());
			
			st.setInt(5, hospital.getHospitalId());
			st.executeUpdate();
			retVal = true;
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return retVal;
	}
	
	public boolean removeHospital(int id) {
		String QUERY = "DELETE FROM Hospitals WHERE hostId =?";
		try {
			PreparedStatement st = conn.prepareStatement(QUERY);
			st.setInt(1, id);
			st.executeUpdate();
			return true;
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
		
	}
	
	
	
	
}
	

