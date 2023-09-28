package com.tso7121.telemedicine.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tso7121.telemedicine.model.Appointment;
import com.tso7121.telemedicine.model.User;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    Optional<Appointment> findById(long id);

    List<Appointment> findByDoctor(User doctorId);

    List<Appointment> findByPatient(User patientId);

    List<Appointment> findByDoctorAndPatient(User doctor, User patient);

}
