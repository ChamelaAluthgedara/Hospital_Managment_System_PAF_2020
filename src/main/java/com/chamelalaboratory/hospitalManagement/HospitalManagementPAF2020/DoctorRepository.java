package com.chamelalaboratory.hospitalManagement.HospitalManagementPAF2020;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class DoctorRepository 
{

	List<Doctor> doctors;
	
	Connection con = null;
	
	public DoctorRepository()
	{
		String url = "jdbc:mysql://localhost:3306/pafHospitalManagementDB";
		String username = "root";
		String password = "";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
			System.out.println("DB Connected Successfully !!!");

		}
		catch(Exception e)
		{
			System.out.println("DB Connection Lost ....");
			
			System.out.println(e);
		}
	}
	
	// retrive all registered doctors in db.
	public List<Doctor> getDoctors()
	{
		List<Doctor> doctors = new ArrayList<>();
		
		String sql = "select * from Doctor";
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Doctor d = new Doctor();
				d.setDocID(rs.getInt(1));
				d.setDocFName(rs.getString(2));
				d.setDocLName(rs.getString(3));
				d.setDocPosition(rs.getString(4));
				d.setDocFee(rs.getString(5));
				d.setMobileNo(rs.getInt(6));
				d.setDocAddress(rs.getString(7));
				d.setHosID(rs.getInt(8));
				
				
				doctors.add(d);
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return doctors;
	}
	
	
	// retrive particular registered doctor by id in db
	public Doctor getDoctor(int id) 
	{
		String sql = "select * from Doctor where DocID="+id;
		Doctor d = new Doctor();
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				d.setDocID(rs.getInt(1));
				d.setDocFName(rs.getString(2));
				d.setDocLName(rs.getString(3));
				d.setDocPosition(rs.getString(4));
				d.setDocFee(rs.getString(5));
				d.setMobileNo(rs.getInt(6));
				d.setDocAddress(rs.getString(7));
				
				d.setHosID(rs.getInt(8));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return  d;
	}


	// create new doctor instance
	public boolean Create(Doctor d1) {
		String sql = "insert into Doctor values (?,?,?,?,?,?,?,?)";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, d1.getDocID());
			st.setString(2, d1.getDocFName());
			st.setString(3, d1.getDocLName());
			st.setString(4, d1.getDocPosition());
			st.setString(5, d1.getDocFee());
			st.setInt(6, d1.getMobileNo());
			st.setString(7, d1.getDocAddress());
			st.setInt(8, d1.getHosID());
			
			st.executeUpdate();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
		
	}
	
	
	
	// update current doctor details in db
	public boolean Update(Doctor d1) {
		String sql = "update doctor set DocFName=?, DocLName=?, DocPosition=?, DocFee=?, MobileNo=?, DocAddress=?, HosID=? where DocID=?";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, d1.getDocFName());
			st.setString(2, d1.getDocLName());
			st.setString(3, d1.getDocPosition());
			st.setString(4, d1.getDocFee());
			st.setInt(5, d1.getMobileNo());
			st.setString(6, d1.getDocAddress());
			st.setInt(7, d1.getHosID());
			st.setInt(8, d1.getDocID());
			
			st.executeUpdate();
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}


	// delete doctor details in db
	public boolean kill(int id) {
		
		String sql = "delete from doctor where DocID=?";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			
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
