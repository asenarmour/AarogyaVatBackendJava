package com.aarogyavat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aarogyavat.model.Login;
import com.aarogyavat.model.PatientProfile;
import com.aarogyavat.model.Register;
import com.aarogyavat.repository.PatientRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatientService {
	
	@Autowired
	PatientRepository repo;

	public PatientProfile addPatientProfile(PatientProfile profile) {
		log.info("entered addPatientProfile");
		return repo.save(profile);
	}
	
	public PatientProfile getPatientProfile(Long id) {
		Optional<PatientProfile> profile=repo.findById(id);
		return profile.get();
	}
	
	public PatientProfile updatePatientProfile(PatientProfile profile) throws Exception {
		return repo.save(profile);

	}

	public PatientProfile registerProfile(Register register) {
		PatientProfile profile=new PatientProfile();
		profile.setPassword(register.getPassword());
		profile.setEmail(register.getEmail());
		profile.setName(register.getUsername());
		return repo.save(profile);
		
	}

	public PatientProfile loginPatient(Login login) {
		PatientProfile profile=repo.getProfileByEmail(login.getEmail());
		if(profile!=null) {
			if(login.getPassword().equalsIgnoreCase(profile.getPassword())) {
				return profile;
			}
		}
		return null;
	}
}
