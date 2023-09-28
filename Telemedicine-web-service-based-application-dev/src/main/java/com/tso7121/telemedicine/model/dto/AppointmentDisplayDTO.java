package com.tso7121.telemedicine.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentDisplayDTO {
    private long id;
    private String patient;
    private String doctor;
    private String appointment_at;
    private String createdAt;
    private String updatedAt;
}
