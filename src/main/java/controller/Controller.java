package controller;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Hospital;
//import repo.HospitalRepo;


@Path("HospitalRegistration")
public class Controller {

	//HospitalRepo repo = new HospitalRepo();
	
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Hospital> getAllHospitals() {
    	System.out.println("POp lol");
        //repo.getAllHospitals();
    	Hospital ho = new Hospital();
    	
    	ho.setId(12);
    	ho.setAddress("looo/ff");
    	ho.setCharge(344.00);
    	ho.setName("kings");
    	
    	Hospital ho2 = new Hospital();
    	
    	ho2.setId(132);
    	ho2.setAddress("loo/ff");
    	ho2.setCharge(34.00);
    	ho2.setName("kngs");
    	
    	List<Hospital> hosList = new ArrayList<Hospital>();
    	hosList.add(ho);
    	return hosList;
        
	
	
    }
    
	
	
}