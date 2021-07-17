package com.aarogyavat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="patient_profile")
public class PatientProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name ;
	private String phoneNumber; 
	private String password;
	private String email ;
	private String gender ;
	private String dob ;
	private String bloodGroup; 
	private String addressLine1 ;
	private String addressLine2 ;
	private String city ;
	private String state ;
	private String country; 
	private String pincode ;
}
