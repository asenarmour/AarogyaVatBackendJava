package com.aarogyavat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aarogyavat.model.DoctorProfile;


@Repository
public interface DoctorRepository extends JpaRepository<DoctorProfile, Long>{

	@Query("select d from DoctorProfile d where d.speciality=:speciality")
	List<DoctorProfile> getDoctorBySpeciality(String speciality);
}
