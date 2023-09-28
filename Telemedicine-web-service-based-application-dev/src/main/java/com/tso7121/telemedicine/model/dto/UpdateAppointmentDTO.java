package com.tso7121.telemedicine.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAppointmentDTO {
    private int id;
    private int patient;
    private int doctor;
    private String appointment_at;
}
