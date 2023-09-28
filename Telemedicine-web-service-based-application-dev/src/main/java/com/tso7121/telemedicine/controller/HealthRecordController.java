package com.tso7121.telemedicine.controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tso7121.telemedicine.model.HealthRecord;
import com.tso7121.telemedicine.model.dto.HealthRecordDisplayDTO;
import com.tso7121.telemedicine.service.HealthRecordService;

@RestController
@RequestMapping("/healthrecords")
@CrossOrigin(origins = "http://localhost:3000")
public class HealthRecordController {
    
    @Autowired
    private HealthRecordService healthRecordService;

    @GetMapping
    public List<HealthRecord> getAllHealthRecords() throws Exception {
        return healthRecordService.getAllHealthRecords();
    }

    @GetMapping("/{id}")
    public List<HealthRecordDisplayDTO> getHealthRecordByPatientId(@PathVariable int id) throws Exception {
        List<HealthRecordDisplayDTO> resultList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss a");
        List<HealthRecord> billingList = healthRecordService.getHealthRecordByPatientId(id);
        for (HealthRecord healthRecord : billingList) {
            HealthRecordDisplayDTO displayDTO = new HealthRecordDisplayDTO();
            displayDTO.setPatient(healthRecord.getPatientName());
            displayDTO.setId(healthRecord.getId());
            displayDTO.setBmi(healthRecord.getBmi());
            displayDTO.setHeight(healthRecord.getHeight());
            displayDTO.setWeight(healthRecord.getWeight());
            displayDTO.setBloodType(healthRecord.getBloodType());
            displayDTO.setNotes(healthRecord.getNotes());
            String formattedCreatedDateTime = healthRecord.getCreatedAt().format(formatter);
            String formattedLastUpdatedDateTime = healthRecord.getUpdatedAt().format(formatter);
            displayDTO.setUpdatedAt(formattedLastUpdatedDateTime);
            displayDTO.setCreatedAt(formattedCreatedDateTime);
            resultList.add(displayDTO);
        }
        return resultList;
    }

    @PostMapping
    public HealthRecord createHealthRecord(@RequestBody HealthRecord healthRecord)
            throws Exception {
        return healthRecordService.createHealthRecord(healthRecord);
    }

    @PutMapping
    public HealthRecord updateHealthRecord(@RequestBody HealthRecord healthRecord)
            throws Exception {
        return healthRecordService.updateHealthRecord(healthRecord);
    }
}
