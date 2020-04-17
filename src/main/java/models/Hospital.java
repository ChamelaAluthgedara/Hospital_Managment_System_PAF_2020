package models;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Hospital {
	
	private int hospitalId;
	private String hospitalName;
	private String address;
	private int contNum;
	private double charge;

	//Setters
	public void setId(int hosId) {
		this.hospitalId = hosId;
	}
	public void setName(String hosName) {
		this.hospitalName = hosName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setContactNum(int contNum) {
		this.contNum = contNum;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}

	
	// Getters
	public int getHospitalId() {
		return this.hospitalId;
	}
	public String getHospitalName() {
		return this.hospitalName;
	}
	public String getAddress() {
		return this.address;
	}
	public int getContactNum() {
		return this.contNum;
	}
	public double getCharges() {
		return this.charge;
	}
	
	
}
