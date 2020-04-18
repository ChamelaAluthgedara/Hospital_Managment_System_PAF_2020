package controller;

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

import models.Hospital;
import repo.HospitalRepo;


@Path("HospitalRegistration")
public class Controller {

	HospitalRepo repo = new HospitalRepo();
	
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Hospital> getAllHospitals() {
    	System.out.println("GET called...");
    	System.out.println(repo.getAllHospitals().toString());
        return repo.getAllHospitals();
    	
      }
    
    //Retrieve a data of a specific hospital
    
    @GET
    @Path("get/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Hospital getHospital( @PathParam("id") int id ) {
    	return repo.getHospital(id);
    }
    
    
    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public void addHospital(Hospital hos) {
    	System.out.println(hos);
    	System.out.println(hos.toString());
    	repo.addHospital(hos);
    }
    
    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateHospital(Hospital hospital) {
    	repo.updateHospital(hospital);
    }
    
    
    @DELETE
    @Path("remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String removeHospital(@PathParam("id") int id) {
    	if(repo.removeHospital(id))
    	{
    		return "Delete Complete";
    	}
    	else
    	{
    		return "Task Fail.";
    	}
    }
    
    
    
	
	
}