package com.tso7121.telemedicine.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.sql.DataSource;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tso7121.telemedicine.model.Billing;
import com.tso7121.telemedicine.model.Medication;
import com.tso7121.telemedicine.model.User;
import com.tso7121.telemedicine.model.dto.AddMedicationToBillingDTO;
import com.tso7121.telemedicine.model.dto.UpdateBillingDTO;
import com.tso7121.telemedicine.repository.BillingRepository;
import com.tso7121.telemedicine.service.BillingService;
import com.tso7121.telemedicine.service.MedicationService;
import com.tso7121.telemedicine.service.UserService;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private MedicationService medicationService;

    @Autowired
    private UserService userService;

    @Autowired
    private BillingRepository billingRepository;

    @Override
    public List<Billing> getAllBilling() throws Exception {
        return billingRepository.findAll();
    }

    @Override
    public Billing createBilling(Billing billing) throws Exception {
        return billingRepository.save(billing);
    }

    @Override
    public void addMedication(AddMedicationToBillingDTO dto) throws Exception {
        Optional<Billing> billing = billingRepository.findById(dto.getId());
        if (billing.isPresent()) {
            Billing bill = billing.get();
            int[] medicationIds = dto.getMedicationList();
            for (int i = 0; i < medicationIds.length; i++) {
                Medication medication = medicationService.getMedicationById(medicationIds[i]);
                if (medication != null) {
                    bill.addMedicationRecord(medication);
                }
            }
            billingRepository.saveAndFlush(bill);
        } else {
            throw new Exception("Billing not found");
        }
    }

    @Override
    public List<Billing> getBillingByDTO(UpdateBillingDTO dto) {
        int doctorId = dto.getDoctor();
        int patientId = dto.getPatient();
        List<Billing> result = new ArrayList<Billing>();
        if (doctorId != 0 && patientId != 0) {
            User doctor = userService.getUserById(doctorId);
            User patient = userService.getUserById(patientId);
            result = billingRepository.findByDoctorAndPatient(doctor, patient);
        } else if (doctorId != 0) {
            User doctor = userService.getUserById(doctorId);
            result = billingRepository.findByPatient(doctor);
        } else if (patientId != 0) {
            User patient = userService.getUserById(patientId);
            result = billingRepository.findByPatient(patient);
        }
        return result;
    }

    @Override
    public Billing updateBilling(UpdateBillingDTO dto) throws Exception {
        Optional<Billing> billing = billingRepository.findById(dto.getId());
        if (billing.isPresent()) {
            Billing bill = billing.get();
            if (Strings.isNotBlank(bill.getPaymentMethod())) {
                bill.setStatus(dto.getStatus());
                bill.setPaymentMethod(dto.getPaymentMethod());
            }
            return billingRepository.save(bill);
        }
        throw new Exception("Billing not found");

    }
}
