package com.appointmentservice.AppointmentServicePAF2020;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Appointment {
	
	private int AppID;
	private String Name;
	private String Time;
	private int Date;
	private String mobile;
	
	
	public int getAppID() {
		return AppID;
	}


	public void setAppID(int appID) {
		AppID = appID;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getTime() {
		return Time;
	}


	public void setTime(String time) {
		Time = time;
	}


	public int getDate() {
		return Date;
	}


	public void setDate(int date) {
		Date = date;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Override
	public String toString() {
		return "Appointment [AppID=" + AppID + ", Name=" + Name + ", Time=" + Time + ", Date=" + Date + ", mobile="
				+ mobile + "]";
	}
	

}
