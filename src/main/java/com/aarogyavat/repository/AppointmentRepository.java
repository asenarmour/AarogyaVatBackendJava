package com.aarogyavat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aarogyavat.model.Appointment;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

	@Query("select a from Appointment a where a.doctorId=:id")
	List<Appointment> getAppointmentByDoctor(Long id);
	
	@Query("select a from Appointment a where a.patientId=:id")
	List<Appointment> getAppointmentByPatient(Long id);
	
}
