package repo;
import java.util.ArrayList;
import java.util.List;
import models.Hospital;
import java.sql.*;

public class HospitalRepo {
	
	Connection conn = null;
	
	public HospitalRepo() {
	
		String url = "jdbc:mysql://localhost:3306/paf_2020";
		String userName = "root";
		String password = "";
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
		
		
		
	public List<Hospital> getAllHospitals(){
		
		List<Hospital> hosList = new ArrayList<Hospital>();
		
		String QUERY = "SELECT * FROM Hospitals;"; 
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(QUERY);
			
			while( rs.next() ) {
				Hospital hos = new Hospital();
				
				hos.setId( rs.getInt(1) );
				hos.setName( rs.getString(2) );
				hos.setAddress( rs.getString(3) );
				hos.setContactNum( rs.getInt(4) );
				hos.setCharge( rs.getDouble(5) );
				
				hosList.add(hos); // Adding hospital objects
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		return hosList;
		
		
	}
	
	
	
	public List<Hospital> getHospital(int id){ // Returns a specific object
		List<Hospital> hosList = new ArrayList<Hospital>();
		
		String QUERY = "SELECT * FROM Hospitals WHERE hosId = " + id;
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(QUERY);
			
			if( rs.next() ) {
				Hospital hos = new Hospital();
				
				hos.setId( rs.getInt(1) );
				hos.setName( rs.getString(2) );
				hos.setAddress( rs.getString(3) );
				hos.setContactNum( rs.getInt(4) );
				hos.setCharge( rs.getDouble(5) );
				
				hosList.add(hos); // Adding hospital objects
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return hosList;
	}
	
	
	
	public void addHospital(Hospital hospital) {
		
		String QUERY = "INSERT INTO Hospitals() VALUES(?,?,?,?,?)";
		
		try {
			PreparedStatement st = conn.prepareStatement(QUERY);
			
			st.setInt(1, hospital.getHospitalId() );
			st.setString(2, hospital.getHospitalName());
			st.setString(3,  hospital.getAddress());
			st.setInt(4, hospital.getContactNum());
			st.setDouble(5,  hospital.getCharges() );
			
			st.executeUpdate();
			
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
}
	

