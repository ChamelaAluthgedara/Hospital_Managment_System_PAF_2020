package com.chamelalaboratory.hospitalManagement.HospitalManagementPAF_2020;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Doctor {

	 private int DocID;
	 private String DocFName;
	 private String DocLName;
	 private String DocPosition;
	 private String DocFee;
	 private int DocNumber;
	 private String DocAddress;
	 private int hosID;
	 
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
	public String getDocFee() {
		return DocFee;
	}
	public void setDocFee(String docFee) {
		DocFee = docFee;
	}
	public int getDocNumber() {
		return DocNumber;
	}
	public void setDocNumber(int docNumber) {
		DocNumber = docNumber;
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
	 
	 
	 
}
