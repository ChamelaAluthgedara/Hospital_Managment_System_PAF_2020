create database pafHospitalManagementDB2020;

use pafHospitalManagementDB2020;

-- Patient table --------------
DROP TABLE IF EXISTS patient;

CREATE TABLE IF NOT EXISTS patient (
  PID int(11) NOT NULL ,
  FIRST_NAME varchar(45) NOT NULL,
  LAST_NAME varchar(45) NOT NULL,
  USER_NAME varchar(45) NOT NULL,
  AGE int(11) NOT NULL,
  GENDER varchar(10) NOT NULL,
  EMAIL_ADDRESS varchar(45) NOT NULL,
  PERMENT_ADDRESS varchar(45) NOT NULL,
  CONTACT_NO int(10) NOT NULL,
  PASSWORD varchar(45) NOT NULL,
  CONFIRM_PASSWORD varchar(45) NOT NULL,
  PRIMARY KEY (PID)
);
select * from patient;


-- Hospitals table --------------
DROP TABLE IF EXISTS Hospitals;

CREATE TABLE IF NOT EXISTS Hospitals (
  hostId int(11) NOT NULL ,
  hosName varchar(60) NOT NULL,
  address varchar(60) NOT NULL,
  contNum int(11) NOT NULL,
  hosCharges double NOT NULL,
  PRIMARY KEY (hostId)
);


-- Doctor table --------------
DROP TABLE IF EXISTS Doctor;

CREATE TABLE IF NOT EXISTS Doctor (
  DocID int(4) NOT NULL,
  DocFName varchar(20) NOT NULL,
  DocLName varchar(20) NOT NULL,
  DocPosition varchar(40) NOT NULL,
  DocFee varchar(20) NOT NULL,
  MobileNo int(12) NOT NULL,
  DocAddress varchar(150) NOT NULL,
  hosID int(11) NOT NULL,
  PRIMARY KEY (DocID)
);
select * from Doctor;

-- Appointment table --------------
DROP TABLE IF EXISTS appointment;

CREATE TABLE IF NOT EXISTS appointment (
  AppID int(4) NOT NULL,
  Name varchar(30) NOT NULL,
  Time varchar(30) NOT NULL,
  Date int(10) NOT NULL,
  mobile varchar(10) NOT NULL,
  PRIMARY KEY (AppID)
);
select * from appointment;


-- Payment table --------------
DROP TABLE IF EXISTS payment;

CREATE TABLE IF NOT EXISTS payment (
  PaymenID int(4) NOT NULL AUTO_INCREMENT,
  PaymenType char(5) NOT NULL,
  PaymenPrice double NOT NULL,
  PaymenDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (PaymenID)
);
select * from payment;


