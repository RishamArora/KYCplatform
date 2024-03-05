package com.example.KycPlatform.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="CustomerKycDetails")
public class CustomerKyc {
    
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="lname")
	private String lname;
	
	@Column(name="gender")
	private String gender;
	
	
	@Column(name="DOB")
	private Date DOB;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="phoneno")
	private String phoneno;
	
	@Column(name="address")
	private String address;
	
	@Column(name="Aadharno")
	private String Aadharno;
	
	@Column(name="panno")
	private String panno;
	
	@Column(columnDefinition = "LONGBLOB")
	private byte[] aadhar;
	@Column(columnDefinition = "LONGBLOB")
	private byte[] pan;
	
	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getDOB() {
		return DOB;
	}


	public void setDOB(Date dOB) {
		DOB = dOB;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getPhoneNo() {
		return phoneno;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneno = phoneNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAadharno() {
		return Aadharno;
	}


	public void setAadharno(String aadharno) {
		Aadharno = aadharno;
	}


	public String getPanNo() {
		return panno;
	}


	public void setPanNo(String panNo) {
		this.panno = panNo;
	}


	public byte[] getAadhar() {
		return aadhar;
	}


	public void setAadhar(byte[] aadhar) {
		this.aadhar = aadhar;
	}


	public byte[] getPan() {
		return pan;
	}


	public void setPan(byte[] pan) {
		this.pan = pan;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getCreatedAt() {
		return CreatedAt;
	}


	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}


	@Column(name="status")
	private String status;
	
	
	@CreationTimestamp
	private Date CreatedAt;
	
	
	
}
