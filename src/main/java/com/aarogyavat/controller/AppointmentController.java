package com.aarogyavat.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aarogyavat.model.Appointment;
import com.aarogyavat.service.AppointmentService;


@RestController
@CrossOrigin("*")
public class AppointmentController {

	@Autowired
	AppointmentService service;
	
	@GetMapping("/get-appointment/{id}")
	public List<HashMap<String,String>> getAppoitment(@PathVariable("id") Long id) {
		return service.getAppointment(id);
	}
	
	@PostMapping("/add-appointment")
	public void addAppoingment(@RequestBody Appointment appointment) {
		try {
			service.addAppointments(appointment);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
