package com.chamelalaboratory.hospitalManagement.HospitalManagementPAF_2020;

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

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
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


	public void Create(Doctor d1) {
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
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	
	
	
	public void Update(Doctor d1) {
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
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}


	public void kill(int id) {
		
		String sql = "delete from doctor where DocID=?";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			
			st.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}


	
	
	
}
