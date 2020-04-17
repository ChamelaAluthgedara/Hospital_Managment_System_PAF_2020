package controller;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import models.Hospital;
import repo.HospitalRepo;


@Path("HospitalRegistration")
public class Controller {

	HospitalRepo repo = new HospitalRepo();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hospital> getAllHospitals() {
    	
        return repo.getAllHospitals();
    	
        
	
	
    }
    
	
	
}