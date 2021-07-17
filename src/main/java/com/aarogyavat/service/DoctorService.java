package com.aarogyavat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aarogyavat.model.DoctorProfile;
import com.aarogyavat.repository.DoctorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DoctorService {

	@Autowired
	DoctorRepository repo;
	
	public List<DoctorProfile> getDoctorBySpeciality(String speciality){
		return repo.getDoctorBySpeciality(speciality);
	}
}
