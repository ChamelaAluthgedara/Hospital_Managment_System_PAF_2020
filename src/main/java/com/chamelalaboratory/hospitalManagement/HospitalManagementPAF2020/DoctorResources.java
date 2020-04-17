package com.chamelalaboratory.hospitalManagement.HospitalManagementPAF2020;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("doctors")
public class DoctorResources {

	DoctorRepository repo = new DoctorRepository();
	
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Doctor> getDoctors() 
	{
		System.out.println(repo.getDoctors().size());
		return repo.getDoctors();	
	}
	
	
	@GET
	@Path ("doctor/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Doctor getDoctor(@PathParam("id")int id) 
	{
		return repo.getDoctor(id);	
	}
	
	
	@POST
	@Path("doctor")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String createDoctor(Doctor d1)
	{
		
		System.out.println(d1);
		
		if(repo.Create(d1))
		{
			
			return "New data Successfully Inserted." + "\nDetails: " + d1;
		}
		else {
			return "Task Failed. Input DocID already exist.";
		}
		
	}
	

	@PUT
	@Path("doctor")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String updateDoctor(Doctor d1)
	{
		Doctor beforeUpdate = repo.getDoctor(d1.getDocID());
		
		System.out.println(d1);
		if(repo.getDoctor(d1.getDocID()).getDocID() == 0) 
		{
			if(repo.Create(d1))
			{
				
				return "Cannot update.Entered DocID not found in database. \nNew doctor deatils row created. \nInfo = " + d1;
			}
			else {
				return "Data Update Task Failed.";
			}
		}
		else
		{
			if(repo.Update(d1))
			{
				List<String> changes = new ArrayList<String>();
				char op = '"';
				
				if( !beforeUpdate.getDocFName().equals(d1.getDocFName())) {
					changes.add("\n" + "Doctor Firstname, " + op+beforeUpdate.getDocFName()+op + " Changed To " + op +d1.getDocFName()+op +"\n");
				}
				if(!beforeUpdate.getDocLName().equals(d1.getDocLName())) {
					changes.add("\n" + "Doctor Lastname, " + op+beforeUpdate.getDocLName()+op + " Changed To " + op +d1.getDocLName()+op +"\n");
				}
				if(!beforeUpdate.getDocPosition().equals(d1.getDocPosition())) {
					changes.add("\n" + "Doctor Position, " + op+beforeUpdate.getDocPosition()+op + " Changed To " + op +d1.getDocPosition()+op +"\n");
				}
				if(!beforeUpdate.getDocFee().equals(d1.getDocFee())) {
					changes.add("\n" + "Doctor Fee, " + op+beforeUpdate.getDocFee()+op + " Changed To " + op +d1.getDocFee()+op +"\n");
				}
				if(beforeUpdate.getMobileNo() != d1.getMobileNo()) {
					changes.add("\n" + "Doctor Mobile No, " + op+beforeUpdate.getMobileNo()+op + " Changed To " + op +d1.getMobileNo()+op +"\n");
				}
				if(!beforeUpdate.getDocAddress().equals(d1.getDocAddress())) {
					changes.add("\n" + "Doctor Address, " + op+beforeUpdate.getDocAddress()+op + " Changed To " + op +d1.getDocAddress()+op +"\n");
				}
				if(beforeUpdate.getHosID() != d1.getHosID()) {
					changes.add("\n" + "Doctor Hospital ID, " + op+beforeUpdate.getHosID()+op + " Changed To " + op +d1.getHosID()+op +"\n");
				}
				
				if(changes.size() == 0) {
					return "No Changes Detected!";

				}
				else
				{
					return "Doctor details updated Successfully.\nAffected Summery = " + changes;

				}
			}
			else {
				return "Update Task Faild.";
			}

		}
		
	}
	
	@DELETE
	@Path ("doctor/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String deleteDoctorDetails(@PathParam("id")int id) 
	{
		Doctor d = repo.getDoctor(id);
		
		if(d.getDocID()!=0) {
			
			if(repo.kill(id))
			{
				return "Doctor details deleted Successfully. \nDeleted details: " + d;
			}
			else
			{
				return "Task Faild.";
			}
		}
		else {
			return "Please Insert Valid DocID.";
		}
		
	}
	
}
