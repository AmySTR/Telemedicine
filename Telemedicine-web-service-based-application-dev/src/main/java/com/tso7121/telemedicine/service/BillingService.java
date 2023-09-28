package com.tso7121.telemedicine.service;

import java.util.List;
import com.tso7121.telemedicine.model.Billing;
import com.tso7121.telemedicine.model.dto.AddMedicationToBillingDTO;
import com.tso7121.telemedicine.model.dto.UpdateBillingDTO;

public interface BillingService {

    List<Billing> getAllBilling() throws Exception;

    Billing createBilling(Billing billing) throws Exception;

    Billing updateBilling(UpdateBillingDTO billing) throws Exception;

    List<Billing> getBillingByDTO(UpdateBillingDTO dto) throws Exception;

    void addMedication(AddMedicationToBillingDTO dto) throws Exception;

}
