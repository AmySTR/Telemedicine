package com.tso7121.telemedicine.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tso7121.telemedicine.model.HealthRecord;
import com.tso7121.telemedicine.model.Medication;
import com.tso7121.telemedicine.repository.HealthRecordRepository;
import com.tso7121.telemedicine.repository.MedicationRepository;
import com.tso7121.telemedicine.service.HealthRecordService;
import com.tso7121.telemedicine.service.MedicationService;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    @Override
    public List<Medication> getAllMedication() {
        return medicationRepository.findAll();
    }

    @Override
    public Medication createMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    @Override
    public Medication updateMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    @Override
    public void deleteMedication(int id) {
        medicationRepository.deleteById(id);
    }

    @Override
    public Medication getMedicationById(int id) throws Exception {
        Optional<Medication> medication = medicationRepository.findById(id);
        if (medication.isPresent()) {
            return medication.get();
        } else
            throw new Exception(" record not found");
    }

}
