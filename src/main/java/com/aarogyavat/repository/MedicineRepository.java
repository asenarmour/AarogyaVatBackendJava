package com.aarogyavat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aarogyavat.model.Medicine;


@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Long>{

	@Query(value="select m from Medicine m where m.type=:type")
	List<Medicine> getMedicineByType(String type);
}
