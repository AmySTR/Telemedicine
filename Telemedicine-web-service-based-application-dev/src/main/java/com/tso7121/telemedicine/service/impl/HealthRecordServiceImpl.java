package com.tso7121.telemedicine.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tso7121.telemedicine.model.HealthRecord;
import com.tso7121.telemedicine.model.User;
import com.tso7121.telemedicine.repository.HealthRecordRepository;
import com.tso7121.telemedicine.repository.UserRepository;
import com.tso7121.telemedicine.service.HealthRecordService;

@Service
public class HealthRecordServiceImpl implements HealthRecordService {

    @Autowired
    private HealthRecordRepository healthRecordRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<HealthRecord> getAllHealthRecords() {
        return healthRecordRepository.findAll();
    }

    @Override
    public List<HealthRecord> getHealthRecordByPatientId(int id) {
        Optional<User> patient = userRepository.findById(id);
        if (patient.isPresent()) {
            User result = patient.get();
            return healthRecordRepository.findByPatient(result);
        }
        return null;
    }

    @Override
    public HealthRecord createHealthRecord(HealthRecord healthgRecord) {
        return healthRecordRepository.save(healthgRecord);
    }

    @Override
    public HealthRecord updateHealthRecord(HealthRecord healthgRecord) {
        return healthRecordRepository.save(healthgRecord);
    }

    @Override
    public void deleteHealthRecord(int id) {
        healthRecordRepository.deleteById(id);
    }

    @Override
    public HealthRecord getHealthRecordById(int id) throws Exception {
        Optional<HealthRecord> healthRecord = healthRecordRepository.findById(id);
        if (healthRecord.isPresent()) {
            return healthRecord.get();
        } else
            throw new Exception(" record not found");
    }

}
