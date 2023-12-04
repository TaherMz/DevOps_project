package com.example.devopsproject.repps;

import com.example.devopsproject.entities.MedicalRecord;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    List<MedicalRecord> findByDatenaiss(LocalDate datenaiss);
}
