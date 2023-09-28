package com.tso7121.telemedicine.controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.tso7121.telemedicine.model.dto.AppointmentDisplayDTO;
import com.tso7121.telemedicine.model.dto.UpdateAppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tso7121.telemedicine.model.Appointment;
import com.tso7121.telemedicine.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getUserById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(null, id);
    }


    @PostMapping("/search")
    public List<AppointmentDisplayDTO> getResultById(@RequestBody UpdateAppointmentDTO dto) {
        List<AppointmentDisplayDTO> resultList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss a");
        List<Appointment> billingList = appointmentService.getAppointmentByDTO(dto);
        for (Appointment appointment : billingList) {
            AppointmentDisplayDTO displayDTO = new AppointmentDisplayDTO();
            displayDTO.setDoctor(appointment.getDoctorName());
            displayDTO.setPatient(appointment.getPatientName());
            displayDTO.setId(appointment.getId());
            String formattedAppointmentDateTime = appointment.getAppointment_at().format(formatter);
            String formattedCreatedDateTime = appointment.getCreatedAt().format(formatter);
            String formattedLastUpdatedDateTime = appointment.getUpdatedAt().format(formatter);
            displayDTO.setUpdatedAt(formattedLastUpdatedDateTime);
            displayDTO.setCreatedAt(formattedCreatedDateTime);
            displayDTO.setAppointment_at(formattedAppointmentDateTime);
            resultList.add(displayDTO);
        }
        return resultList;
    }

    @PostMapping
    public void createAppointment(@RequestBody Appointment appointment) {
        appointmentService.addAppointment(appointment);
    }

    @PutMapping
    public void updateAppointMent(@RequestBody UpdateAppointmentDTO appointment) {
        appointmentService.updateAppointMent(appointment);
    }

    @DeleteMapping
    public void deleteAppointMent(@RequestBody Appointment appointment) {
        appointmentService.deleteAppointment(appointment);
    }
}
