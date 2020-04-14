package com.chamelalaboratory.hospitalManagement.HospitalManagementPAF_2020;

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
		System.out.println("getDoctor Called ...");
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
	public Doctor createDoctor(Doctor d1)
	{
		
		System.out.println(d1);
		repo.Create(d1);
		return d1;
	}
	

	@PUT
	@Path("doctor")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Doctor updateDoctor(Doctor d1)
	{
		
		System.out.println(d1);
		if(repo.getDoctor(d1.getDocID()).getDocID() == 0) 
		{
			repo.Create(d1);
		}
		else
		{
			repo.Update(d1);

		}
		return d1;
	}
	
	@DELETE
	@Path ("doctor/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Doctor deleteDoctorDetails(@PathParam("id")int id) 
	{
		Doctor d = repo.getDoctor(id);
		
		if(d.getDocID()!=0) {
			repo.kill(id);
		}
		
		return d;	
	}
	
}
