package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hospital {
	
	private int hospitalId;
	private String hospitalName;
	private String address;
	private int contNum;
	private double charge;
	
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContNum() {
		return contNum;
	}
	public void setContNum(int contNum) {
		this.contNum = contNum;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", address=" + address
				+ ", contNum=" + contNum + ", charge=" + charge + "]";
	}

	
	
	
}
