package com.aarogyavat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aarogyavat.model.PatientProfile;



@Repository
public interface PatientRepository extends JpaRepository<PatientProfile, Long>{

	@Query("select p from PatientProfile p where p.email=?1")
	public PatientProfile getProfileByEmail(String email);
}
