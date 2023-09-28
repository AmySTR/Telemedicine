package com.tso7121.telemedicine.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tso7121.telemedicine.model.Billing;
import com.tso7121.telemedicine.model.User;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer> {
    List<Billing> findByDoctor(User doctorId);

    List<Billing> findByPatient(User patientId);

    List<Billing> findByDoctorAndPatient(User doctor, User patient);
}
