package com.PAFproject.com.login;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.*;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	Client client = ClientBuilder.newClient();
    	Payment payment	= client.target("http://localhost:8080/HospitalManagementPAF2020/HealthCare/onlinepayment/payment/1").request(MediaType.APPLICATION_JSON).get(Payment.class);
    	
    	String s = payment.getPtype();
    	
        return s;
    }
}
