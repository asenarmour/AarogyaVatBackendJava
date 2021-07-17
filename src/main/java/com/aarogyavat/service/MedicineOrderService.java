package com.aarogyavat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aarogyavat.model.Medicine;
import com.aarogyavat.model.MedicineOrder;
import com.aarogyavat.repository.MedicineOrderRepository;
import com.aarogyavat.repository.MedicineRepository;



@Service
public class MedicineOrderService {

	@Autowired
	MedicineRepository repo;
	
	@Autowired
	MedicineOrderRepository orderRepo;
	
	public void addOrder(Long medicineId,Long patientId) {
		MedicineOrder order=new MedicineOrder();
		order.setMedicineId(medicineId);
		order.setPatientId(patientId);
		orderRepo.save(order);
	}
	
	public List<Medicine> getMedicine(Long patientId) {
		List<MedicineOrder> order=orderRepo.getByPatientId(patientId);
		List<Medicine> medicines=new ArrayList<>();
		for(int i=0;i<order.size();i++) {
			Long medicineId=order.get(i).getMedicineId();
			medicines.add(repo.findById(medicineId).get());
		}
		
		return medicines;
	}
	
	public List<Medicine> getMedicineByType(String type){
		return repo.getMedicineByType(type);
	}
}
