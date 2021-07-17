package com.aarogyavat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aarogyavat.model.Medicine;
import com.aarogyavat.repository.MedicineRepository;
import com.aarogyavat.service.MedicineOrderService;


@RestController
@CrossOrigin("*")
public class MedicineOrderController {

	@Autowired
	MedicineOrderService orderService;
	
	@Autowired
	MedicineRepository medicineRepo;
	
	@GetMapping("/add-order/{medicineId}/{patientId}")
	public void addOrder(@PathVariable("medicineId") Long medicineId, @PathVariable("patientId")  Long patientId) {
		orderService.addOrder(medicineId, patientId);
	}
	
	@GetMapping("/get-order/{patientId}")
	public List<Medicine> getMedicine(@PathVariable("patientId") Long patientId) {
		return orderService.getMedicine(patientId);
	}
	
	@GetMapping("/get-medicine-by-type/{type}")
	public List<Medicine> getMedicineByType(@PathVariable("type") String type){
		return orderService.getMedicineByType(type);
	}
	
	@PostMapping("/add-medicines")
	public void addMedicine(@RequestBody List<Medicine> medicine) {
		medicineRepo.saveAll(medicine);
	}
}
