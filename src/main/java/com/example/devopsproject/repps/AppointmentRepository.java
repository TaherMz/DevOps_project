package com.example.devopsproject.repps;

import com.example.devopsproject.entities.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByFirstname(String firstname);
    List<Appointment> findByAppointmentDate(LocalDate appointmentDate);


}
