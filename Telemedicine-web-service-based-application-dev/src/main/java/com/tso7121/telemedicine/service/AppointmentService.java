package com.tso7121.telemedicine.service;

import java.util.List;
import com.tso7121.telemedicine.model.Appointment;
import com.tso7121.telemedicine.model.User;
import com.tso7121.telemedicine.model.dto.UpdateAppointmentDTO;

public interface AppointmentService {

    List<Appointment> getAllAppointments();
    
    void addAppointment(Appointment appointment);

    void updateAppointMent(UpdateAppointmentDTO appointment);

    void deleteAppointment(Appointment appointment);
    
    Appointment getAppointmentById(User user, Long id);

    List<Appointment> getAppointmentByDTO(UpdateAppointmentDTO dto);

    List<Appointment> getAppointmentsForDoctor(User doctor);

    List<Appointment> getAppointmentsForPatient(User patient);
}
