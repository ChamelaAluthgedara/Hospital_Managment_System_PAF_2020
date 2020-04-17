package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Patient;

//For JSON
import com.google.gson.*;
import com.mysql.cj.xdevapi.JsonParser;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document; 


@Path("/Patient")
public class PatientService {
	
	Patient patientObj = new Patient();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPatient(){
		
		return patientObj.readPatient();
		
	}
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN) 
	public String InsertPatient(@FormParam("FIRST_NAME")String firstname , @FormParam("LAST_NAME")String lastName , 
			@FormParam("USER_NAME")String userName , @FormParam("AGE")int age ,
			@FormParam("GENDER")String gender ,@FormParam("EMAIL_ADDRESS")String email ,
			@FormParam("PERMENT_ADDRESS")String permenentAddress , @FormParam("PASSWORD")String passsword , 
			@FormParam("CONFIRM_PASSWORD")String confPassword ) {
		
		Patient patientObj = new Patient();
		
		String output = patientObj.insertPatient(firstname, lastName, userName, age, gender, email, permenentAddress, passsword, confPassword);
		return output ;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN) 
	public String Updatepatient(String patientData) {
		
		JsonObject patientob = new com.google.gson.JsonParser().parse(patientData).getAsJsonObject(); 
		
		
		//Read value from Json
		String pdi = patientob.get("PID").getAsString();
		String firstname = patientob.get("FIRST_NAME").getAsString();
		String lastName = patientob.get("LAST_NAME").getAsString();
		String username = patientob.get("USER_NAME").getAsString();
		String age = patientob.get("AGE").getAsString();
		String gender = patientob.get("GENDER").getAsString();
		String email = patientob.get("EMAIL_ADDRESS").getAsString();
		String permenentAddress = patientob.get("PERMENT_ADDRESS").getAsString();
		String passsword = patientob.get("PASSWORD").getAsString();
		String confPassword = patientob.get("CONFIRM_PASSWORD").getAsString();
		
		Patient patientObj = new Patient();
		
		String output = patientObj.UpdatePatient(pdi, firstname, lastName, username, age, gender, email, permenentAddress, passsword, confPassword);
		return output ;
		
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN) 
	public String Deletepatient(String patientData) {
		
		Document doc =Jsoup.parse(patientData , "" , Parser.xmlParser());
		
		String pid = doc.select("PID").text();
		
		Patient patientObj = new Patient();
		String output = patientObj.Deletepatient(pid);
		
		return output;
		
	}
	
	
	

}
