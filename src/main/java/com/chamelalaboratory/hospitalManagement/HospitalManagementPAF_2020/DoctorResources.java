package com.chamelalaboratory.hospitalManagement.HospitalManagementPAF_2020;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.w3c.dom.stylesheets.MediaList;

@Path("doctor")
public class DoctorResources {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Doctor getDoctor() {
		Doctor d1 = new Doctor();
		
		System.out.println("getDoctor Called ...");
		d1.setDocID(123);
		d1.setDocFName("Chamela");
		d1.setDocLName("Aluthgedara");
		d1.setDocPosition("Dentist");
		d1.setDocAddress("Kadawatha");
		d1.setDocFee("12000");
		d1.setHosID(1233);
		
		return d1;
		
	}
}
