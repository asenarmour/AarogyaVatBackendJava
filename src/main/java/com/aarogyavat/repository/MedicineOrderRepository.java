package com.aarogyavat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aarogyavat.model.MedicineOrder;


@Repository
public interface MedicineOrderRepository extends JpaRepository<MedicineOrder, Long>{

	@Query(value="select m from MedicineOrder m where m.patientId=:id")
	List<MedicineOrder> getByPatientId(Long id);
}
