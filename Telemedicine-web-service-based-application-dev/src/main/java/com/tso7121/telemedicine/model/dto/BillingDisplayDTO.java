package com.tso7121.telemedicine.model.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillingDisplayDTO {
    private long id;
    private String patient;
    private String doctor;
    private String paymentMethod;
    private String status;
    private Double amount;
    private List<MedicationDisplayDTO> medicationList = new ArrayList<>();
    private String createdAt;
    private String updatedAt;
}
