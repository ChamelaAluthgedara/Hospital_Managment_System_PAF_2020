package com.appointmentservice.AppointmentServicePAF2020;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AppointmentRepository {
	
	
	Connection con = null;
	
	public AppointmentRepository()
	{
		String url = "jdbc:mysql://localhost:3306/pafHospitalManagementDB2020";
		String username = "root";
		String password = "";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		     con = DriverManager.getConnection(url,username,password);
		     System.out.println("DB COnnected");
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public List<Appointment> getAppointments()
	{	
		List<Appointment> appointments = new ArrayList<>();
		String sql = "select * from appointment";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Appointment a = new Appointment();
				a.setAppID(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setTime(rs.getString(3));
				a.setDate(rs.getInt(4));
				a.setMobile(rs.getString(5));
				
				appointments.add(a);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
        
        System.out.println("From Repo : " +appointments.toString());
		return appointments;
	}

	public Appointment getAppointment(int appID)
	{
		
		String sql = "select * from appointment where AppID="+appID;
		Appointment a = new Appointment();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next());
			{
				
				a.setAppID(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setTime(rs.getString(3));
				a.setDate(rs.getInt(4));
				a.setMobile(rs.getString(5));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return a;

	}

	public boolean create(Appointment a1) {
		String sql = "insert into appointment values (?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, a1.getAppID());
			st.setString(2, a1.getName());
			st.setString(3, a1.getTime());
			st.setInt(4, a1.getDate());
			st.setString(5, a1.getMobile());
			st.executeUpdate();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	public boolean update(Appointment a1) {
		String sql = "update appointment set Name=?, Time=?, Date=?, mobile=? where AppID=?;";
		try {
			PreparedStatement st = con.prepareStatement(sql);
		
			st.setString(1, a1.getName());
			st.setString(2, a1.getTime());
			st.setInt(3, a1.getDate());
			st.setString(4, a1.getMobile());
			st.setInt(5, a1.getAppID());
			st.executeUpdate();
			
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	public boolean delete(int appID) {
		String sql = "delete from appointment where AppID=?;";
		try {
			PreparedStatement st = con.prepareStatement(sql);
		
			st.setInt(1, appID);
			st.executeUpdate();
			
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}
	
}
