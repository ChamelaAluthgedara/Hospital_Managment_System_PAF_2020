package com.appointmentservice.AppointmentServicePAF2020;

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

@Path("appointments")
public class AppointmentResource {
	
	//private static final int JUN = 0;
	
	AppointmentRepository repo = new AppointmentRepository();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Appointment> getAppointment()
	{
		System.out.println("getAppointment API called....");
		return repo.getAppointments();
	}
	
	@POST
	@Path("appointment")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createAppointment(Appointment a1)
	{
		System.out.println("POST method: " + a1.toString());
		//repo.create(a1);
		if(repo.create(a1))
		{
			return "Data insert successfull";
		}
		else {
			return "Error.";
		}
		
	}
	
	@PUT
	@Path("appointment")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateAppointment(Appointment a1)
	{
		System.out.println("POST method: " + a1.toString());
		if(repo.getAppointment(a1.getAppID()).getAppID()==0)
		{
			if(repo.create(a1))
			{
				return "New Data Inserted";
			}
			else
				return "Error";
		}
		else {
			//repo.create(a1);
			
			if(repo.update(a1))
			{
				return "Data Updated.";
			}
			else
				return "Error";
			
		}
		
		
	}

	@DELETE
	@Path("appointment/AppID")
	public Appointment killAppointment(@PathParam("AppID")int AppID)
	{
		Appointment a = repo.getAppointment(AppID);
		
		if(a.getAppID()!=0)
			repo.delete(AppID);
		
		return a;
	}
}
