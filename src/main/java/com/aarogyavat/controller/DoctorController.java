package com.aarogyavat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aarogyavat.model.DoctorProfile;
import com.aarogyavat.repository.DoctorRepository;


@RestController
@CrossOrigin("*")
public class DoctorController {

	@Autowired
	DoctorRepository repo;
	
	@PostMapping("/doctor")
	public void addDoc(@RequestBody DoctorProfile doc) {
		repo.save(doc);
	}
	
	@GetMapping("/doctor/{speciality}")
	public List<DoctorProfile> getDoctorBySpeciality(@PathVariable("speciality") String speciality){
		return repo.getDoctorBySpeciality(speciality);
	}
}
