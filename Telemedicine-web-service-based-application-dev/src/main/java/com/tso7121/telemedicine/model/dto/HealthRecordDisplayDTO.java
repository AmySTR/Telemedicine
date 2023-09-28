package com.tso7121.telemedicine.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HealthRecordDisplayDTO {
    private long id;
    private String patient;
    private Double bmi;
    private String bloodType;
    private Double height;
    private Double weight;
    private String notes;
    private String createdAt;
    private String updatedAt;
}
