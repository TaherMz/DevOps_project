package com.example.devopsproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_medrec;
    private LocalDate datenaiss;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String diagnosis;
    private String treatment;

    public Long getId_medrec() {
        return id_medrec;
    }

    public void setId_medrec(Long id_medrec) {
        this.id_medrec = id_medrec;
    }

    public LocalDate getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(LocalDate datenaiss) {
        this.datenaiss = datenaiss;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
