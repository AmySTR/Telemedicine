package com.tso7121.telemedicine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tso7121.telemedicine.model.Medication;

@Repository
public interface MedicationRepository  extends JpaRepository<Medication, Integer>{
    
}
