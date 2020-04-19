package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;
import com.mysql.cj.xdevapi.JsonParser;

import model.Patient;
import service.PatientService;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document; 


@Path("/Patient")
public class PatientServiceController {
	Patient patientOb = new Patient();
	
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPatient(){
		PatientService patientServiceObj = new PatientService();
		
		return patientServiceObj.readPatient();
		
	}
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN) 
	public String InsertPatient(String patientData) {
		
		JsonObject patientob = new com.google.gson.JsonParser().parse(patientData).getAsJsonObject(); 
		
		String pid = patientob.get("PID").getAsString();
		String firstname = patientob.get("FIRST_NAME").getAsString();
		String lastName = patientob.get("LAST_NAME").getAsString();
		String username = patientob.get("USER_NAME").getAsString();
		String age = patientob.get("AGE").getAsString();
		String gender = patientob.get("GENDER").getAsString();
		String email = patientob.get("EMAIL_ADDRESS").getAsString();
		String permenentAddress = patientob.get("PERMENT_ADDRESS").getAsString();
		String ContactNumber = patientob.get("CONTACT_NO").getAsString();
		String passsword = patientob.get("PASSWORD").getAsString();
		String confPassword = patientob.get("CONFIRM_PASSWORD").getAsString();
		
		
		
		patientOb.setPid(Integer.parseInt(pid));
		patientOb.setFirstName(firstname);
		patientOb.setLastName(lastName);
		patientOb.setUserName(username);
		patientOb.setAge(Integer.parseInt(age));
		patientOb.setGender(gender);
		patientOb.setEmailAddress(email);
		patientOb.setPermenentAddress(permenentAddress);
		patientOb.setContactNumber(Integer.parseInt(ContactNumber));
		patientOb.setPassword(passsword);
		patientOb.setConfirmPassword(confPassword);
		
		
		PatientService patientServiceObj = new PatientService();
		String output = patientServiceObj.insertPatient(patientOb);
		return output ;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN) 
	public String Updatepatient(String patientData) {
		
		JsonObject patientob = new com.google.gson.JsonParser().parse(patientData).getAsJsonObject(); 
		
		
		//Read value from Json
		int pid = patientob.get("PID").getAsInt();
		String firstname = patientob.get("FIRST_NAME").getAsString();
		String lastName = patientob.get("LAST_NAME").getAsString();
		String username = patientob.get("USER_NAME").getAsString();
		int age = patientob.get("AGE").getAsInt();
		String gender = patientob.get("GENDER").getAsString();
		String email = patientob.get("EMAIL_ADDRESS").getAsString();
		String permenentAddress = patientob.get("PERMENT_ADDRESS").getAsString();
		int ContactNumber = patientob.get("CONTACT_NO").getAsInt();
		String passsword = patientob.get("PASSWORD").getAsString();
		String confPassword = patientob.get("CONFIRM_PASSWORD").getAsString();
		
		patientOb.setPid(pid);
		patientOb.setFirstName(firstname);
		patientOb.setLastName(lastName);
		patientOb.setUserName(username);
		patientOb.setAge(age);
		patientOb.setGender(gender);
		patientOb.setEmailAddress(email);
		patientOb.setPermenentAddress(permenentAddress);
		patientOb.setContactNumber(ContactNumber);
		patientOb.setPassword(passsword);
		patientOb.setConfirmPassword(confPassword);
		
		PatientService patientServiceObj = new PatientService();
	
		String output = patientServiceObj.UpdatePatient(patientOb);
		return output ;
		
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN) 
	public String Deletepatient(String patientData) {
		
		JsonObject patientob = new com.google.gson.JsonParser().parse(patientData).getAsJsonObject(); 
		
		int pid = patientob.get("PID").getAsInt();
		
		PatientService patientServiceObj = new PatientService();
		String output = patientServiceObj.Deletepatient(pid);
		
		return output;
		
	}
	
	
	

}
