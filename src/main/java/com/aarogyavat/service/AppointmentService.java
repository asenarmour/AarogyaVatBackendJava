package com.aarogyavat.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aarogyavat.model.Appointment;
import com.aarogyavat.model.DoctorProfile;
import com.aarogyavat.model.PatientProfile;
import com.aarogyavat.repository.AppointmentRepository;
import com.aarogyavat.repository.DoctorRepository;
import com.aarogyavat.repository.PatientRepository;


@Service
@Transactional
public class AppointmentService {

	@Autowired
	AppointmentRepository repo;
	
	@Autowired
	DoctorRepository docRepo;
	
	@Autowired
	PatientRepository patientRepo;
	
	public void addAppointments(Appointment appointment) throws ParseException {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(appointment.getDate(), inputFormatter);
		String formattedDate = outputFormatter.format(date);
		appointment.setDate(formattedDate);
		repo.save(appointment);
	}
	
	public List<HashMap<String,String>> getAppointment(Long id) {
		try {
			List<HashMap<String,String>> result=new ArrayList<HashMap<String,String>>();
			Optional<DoctorProfile> doc=docRepo.findById(id);
			Optional<PatientProfile> pat=patientRepo.findById(id);
			List<Appointment> appointment;
			if(doc.isPresent() && pat.isPresent()) {                    // if id is present in both patient and doctor than it is
				appointment= repo.getAppointmentByDoctor(id); 				//doctor profile
				for(Appointment appoint:appointment) {
					HashMap<String,String> hs1=new HashMap<String,String>();
					Optional<PatientProfile> patient=patientRepo.findById(appoint.getPatientId());
					hs1.put("name", patient.get().getName());
					hs1.put("date",appoint.getDate());
					hs1.put("time", appoint.getTime());
					result.add(hs1);
				}
				
			}
			else {                                                           // else it is patient because it won't be present in doctor
				appointment=  repo.getAppointmentByPatient(id);
				for(Appointment appoint:appointment) {
					HashMap<String,String> hs2=new HashMap<String,String>();
					Optional<DoctorProfile> doctor=docRepo.findById(appoint.getDoctorId());
					hs2.put("name", doctor.get().getName());
					hs2.put("date",appoint.getDate());
					hs2.put("time", appoint.getTime());
					result.add(hs2);
				}
			}
			
			return result;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
