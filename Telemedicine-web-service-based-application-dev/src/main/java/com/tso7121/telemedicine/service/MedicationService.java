package com.tso7121.telemedicine.service;

import java.util.List;
import com.tso7121.telemedicine.model.Medication;

public interface MedicationService {
    List<Medication> getAllMedication();

    Medication getMedicationById(int id) throws Exception;

    Medication createMedication(Medication medication) throws Exception;

    Medication updateMedication(Medication medication) throws Exception;

    void deleteMedication(int id);
}
