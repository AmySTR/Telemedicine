package com.tso7121.telemedicine.controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tso7121.telemedicine.model.Billing;
import com.tso7121.telemedicine.model.Medication;
import com.tso7121.telemedicine.model.dto.AddMedicationToBillingDTO;
import com.tso7121.telemedicine.model.dto.BillingDisplayDTO;
import com.tso7121.telemedicine.model.dto.UpdateBillingDTO;
import com.tso7121.telemedicine.service.BillingService;

@RestController
@RequestMapping("/billings")
@CrossOrigin(origins = "http://localhost:3000")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping
    public List<Billing> getAllBilling() throws Exception {
        return billingService.getAllBilling();
    }

    @PostMapping
    public Billing createBilling(@RequestBody Billing billing) throws Exception {
        return billingService.createBilling(billing);
    }

    @PutMapping
    public Billing updateBilling(@RequestBody UpdateBillingDTO billing) throws Exception {
        return billingService.updateBilling(billing);
    }

    @PostMapping("/addMedication")
    public void addMedication(@RequestBody AddMedicationToBillingDTO dto) throws Exception {
        billingService.addMedication(dto);
    }

    @PostMapping("/search")
    public List<BillingDisplayDTO> getResultById(@RequestBody UpdateBillingDTO dto)
            throws Exception {
        List<BillingDisplayDTO> resultList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss a");
        List<Billing> billingList = billingService.getBillingByDTO(dto);
        for (Billing bill : billingList) {
            BillingDisplayDTO displayDTO = new BillingDisplayDTO();
            displayDTO.setDoctor(bill.getDoctorName());
            displayDTO.setPatient(bill.getPatientName());
            displayDTO.setId(bill.getId());
            displayDTO.setAmount(bill.getAmount());
            displayDTO.setPaymentMethod(bill.getPaymentMethod() != null ? bill.getPaymentMethod() : "");
            displayDTO.setStatus(bill.getStatus() != null ? bill.getStatus() : "");

            String formattedCreatedDateTime = bill.getCreatedAt().format(formatter);
            String formattedLastUpdatedDateTime = bill.getUpdatedAt().format(formatter);
            displayDTO.setUpdatedAt(formattedLastUpdatedDateTime);
            displayDTO.setCreatedAt(formattedCreatedDateTime);

            List<Medication> medicationList = bill.getMedicationRecords();
                
            resultList.add(displayDTO);
        }
        return resultList;
    }
}
