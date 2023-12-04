package com.example.devopsproject.repps;

import com.example.devopsproject.entities.Patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
