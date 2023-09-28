package com.tso7121.telemedicine.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicationDisplayDTO {
    private String name;
    private Double description;
    private Double qty;
    private String uom;
}
