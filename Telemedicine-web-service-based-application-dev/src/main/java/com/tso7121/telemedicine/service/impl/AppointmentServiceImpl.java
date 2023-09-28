package com.tso7121.telemedicine.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.tso7121.telemedicine.model.dto.UpdateAppointmentDTO;
import com.tso7121.telemedicine.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tso7121.telemedicine.model.Appointment;
import com.tso7121.telemedicine.model.User;
import com.tso7121.telemedicine.repository.AppointmentRepository;
import com.tso7121.telemedicine.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserService userService;

    @Override
    public void addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAppointmentByDTO(UpdateAppointmentDTO dto) {
        int doctorId = dto.getDoctor();
        int patientId = dto.getPatient();
        List<Appointment> result = new ArrayList<Appointment>();
        if (doctorId != 0 && patientId != 0) {
            User doctor = userService.getUserById(doctorId);
            User patient = userService.getUserById(patientId);
            result = appointmentRepository.findByDoctorAndPatient(doctor, patient);
        } else if (doctorId != 0) {
            User doctor = userService.getUserById(doctorId);
            result = appointmentRepository.findByPatient(doctor);
        } else if (patientId != 0) {
            User patient = userService.getUserById(patientId);
            result = appointmentRepository.findByPatient(patient);
        }
        return result;
    }

    @Override
    public void updateAppointMent(UpdateAppointmentDTO dto) {
        Optional<Appointment> appointment = appointmentRepository.findById(dto.getId());
        if (appointment.isPresent()) {
            Appointment result = appointment.get();
            User doctor = userService.getUserById(dto.getDoctor());
            User patient = userService.getUserById(dto.getPatient());
            result.setDoctor(doctor);
            result.setPatient(patient);
            String format = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            LocalDateTime localDateTime = LocalDateTime.parse(dto.getAppointment_at(), formatter);
            LocalDateTime newDateTime = localDateTime.plusHours(8);
            result.setAppointment_at(newDateTime);
            appointmentRepository.save(result);
        } else {

        }
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        appointmentRepository.delete(appointment);
    }

    @Override
    public Appointment getAppointmentById(User user, Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            return appointment.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<Appointment> getAppointmentsForDoctor(User doctor) {
        return appointmentRepository.findByDoctor(doctor);
    }

    @Override
    public List<Appointment> getAppointmentsForPatient(User patient) {
        return appointmentRepository.findByDoctor(patient);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

}
