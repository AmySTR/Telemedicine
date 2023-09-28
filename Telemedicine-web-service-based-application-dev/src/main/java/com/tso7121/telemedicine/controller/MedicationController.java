package com.tso7121.telemedicine.controller;

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
import com.tso7121.telemedicine.model.Medication;
import com.tso7121.telemedicine.service.MedicationService;

@RestController
@RequestMapping("/medication")
@CrossOrigin(origins = "http://localhost:3000")
public class MedicationController {
    
    @Autowired
    private MedicationService medicationService;

    @GetMapping
    public List<Medication> getAllMedications() throws Exception {
        return medicationService.getAllMedication();
    }

    @GetMapping("/{id}")
    public Medication getMedicationById(@PathVariable int id) throws Exception {
        return medicationService.getMedicationById(id);
    }

    @PostMapping
    public Medication createMedication(@RequestBody Medication Medication)
            throws Exception {
        return medicationService.createMedication(Medication);
    }

    @PutMapping
    public Medication updateMedication(@RequestBody Medication Medication)
            throws Exception {
        return medicationService.updateMedication(Medication);
    }
}
