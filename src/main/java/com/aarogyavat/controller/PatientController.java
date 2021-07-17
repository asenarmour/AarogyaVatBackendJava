package com.aarogyavat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aarogyavat.model.Login;
import com.aarogyavat.model.PatientProfile;
import com.aarogyavat.model.Register;
import com.aarogyavat.service.PatientService;


@RestController
@CrossOrigin("*")
public class PatientController {

	@Autowired
	PatientService service;
	
	@PostMapping("/register")
	public PatientProfile registerProfile(@RequestBody Register register) {
		if(register.getRegisterAs().equalsIgnoreCase("Patient")) {
			return service.registerProfile(register);
		}
		return null;
	}
	
	@PostMapping("/login")
	public PatientProfile loginPatientEntity(@RequestBody Login login) {
			return service.loginPatient(login);
	}
	
	
	
	@PostMapping("/add-patient")
	public PatientProfile addPatientProfile(@RequestBody PatientProfile profile) {
		
		return service.addPatientProfile(profile);
	}
	
	@GetMapping("/get-patient/{id}")
	public PatientProfile addPatientProfile(@PathVariable("id") Long id) {
		
		return service.getPatientProfile(id);
	}
	
	@PostMapping("/update-patient")
	public PatientProfile updateProfile(@RequestBody PatientProfile profile) {
		try {
			return service.updatePatientProfile( profile);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
