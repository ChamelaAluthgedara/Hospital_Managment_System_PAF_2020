package com.chamelalaboratory.hospitalManagement.HospitalManagementPAF_2020;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Doctor {

	 private int DocID;
	 private String DocFName;
	 private String DocLName;
	 private String DocPosition;
	 private String DocFee;
	 private String DocAddress;
	 private int hosID;
	 private int MobileNo;
	 
	
	public int getDocID() {
		return DocID;
	}
	public void setDocID(int docID) {
		DocID = docID;
	}
	public String getDocFName() {
		return DocFName;
	}
	public void setDocFName(String docFName) {
		DocFName = docFName;
	}
	public String getDocLName() {
		return DocLName;
	}
	public void setDocLName(String docLName) {
		DocLName = docLName;
	}
	public String getDocPosition() {
		return DocPosition;
	}
	public void setDocPosition(String docPosition) {
		DocPosition = docPosition;
	}
	public int getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(int mobileNo) {
		MobileNo = mobileNo;
	}
	public String getDocFee() {
		return DocFee;
	}
	public void setDocFee(String docFee) {
		DocFee = docFee;
	}
	public String getDocAddress() {
		return DocAddress;
	}
	public void setDocAddress(String docAddress) {
		DocAddress = docAddress;
	}
	public int getHosID() {
		return hosID;
	}
	public void setHosID(int hosID) {
		this.hosID = hosID;
	}
	@Override
	public String toString() {
		return "Doctor [DocID=" + DocID + ", DocFName=" + DocFName + ", DocLName=" + DocLName + ", DocPosition="
				+ DocPosition + ", DocFee=" + DocFee + ", DocAddress=" + DocAddress + ", hosID=" + hosID + ", MobileNo="
				+ MobileNo + "]";
	}
	
	 
	 
}
