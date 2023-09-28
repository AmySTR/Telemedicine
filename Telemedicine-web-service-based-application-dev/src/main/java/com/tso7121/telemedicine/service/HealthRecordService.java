package com.tso7121.telemedicine.service;

import java.util.List;

import com.tso7121.telemedicine.model.HealthRecord;

public interface HealthRecordService {
    List<HealthRecord> getAllHealthRecords();

    List<HealthRecord> getHealthRecordByPatientId(int id) throws Exception;
    
    HealthRecord getHealthRecordById(int id) throws Exception;

    HealthRecord createHealthRecord(HealthRecord healthgRecord);

    HealthRecord updateHealthRecord(HealthRecord healthgRecord);

    void deleteHealthRecord(int id);
}
