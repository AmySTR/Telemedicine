package com.tso7121.telemedicine.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tso7121.telemedicine.model.HealthRecord;
import com.tso7121.telemedicine.model.User;

@Repository
public interface HealthRecordRepository extends JpaRepository<HealthRecord, Integer> {

    public List<HealthRecord> findByPatient(User patient);

}
