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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Hospital> getAllHospitals() {
    
    	System.out.println(repo.getAllHospitals().toString());
        return repo.getAllHospitals();
    	
      }
    
    //Retrieve a data of a specific hospital
    
    @GET
    @Path("get/{id}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Hospital getHospital( @PathParam("id") int id ) {
    	return repo.getHospital(id);
    }
    
    
    @POST
    @Path("add")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String addHospital(Hospital hos) {
    	
    	if( repo.addHospital(hos) ) {
    		return "The hospital was added.";
    	}
    	else {
    		return "The hospital was added.";
    	}
    }
    
    @PUT
    @Path("update")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String updateHospital(Hospital hospital) {
    	if( repo.updateHospital(hospital) ) {
    		return "Record was updated successfully.";
    	}
    	else {
    		return "Record was not updated successfully.";
    	}
    }
    
    
    @DELETE
    @Path("remove/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String removeHospital(@PathParam("id") int id) {
    	if(repo.removeHospital(id))
    	{
    		return "Record was Deleted";
    	}
    	else
    	{
    		return "Record was not Deleted";
    	}
    }
    
    
    
	
	
}