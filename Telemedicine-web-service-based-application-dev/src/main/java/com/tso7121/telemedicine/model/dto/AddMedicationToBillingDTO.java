package com.tso7121.telemedicine.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMedicationToBillingDTO {
    private int id;
    private int[] medicationList;
}
