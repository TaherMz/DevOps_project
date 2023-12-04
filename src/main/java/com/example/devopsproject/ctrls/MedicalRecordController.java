package com.example.devopsproject.ctrls;


import com.example.devopsproject.entities.MedicalRecord;
import com.example.devopsproject.repps.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class MedicalRecordController {
    @Autowired
    private MedicalRecordRepository medicalRecordRepo;

    //afficher liste de medicalrecords
    @GetMapping("/MedicalRecords/all")
    List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepo.findAll();
    }


    //Add medicalRecord
    @PostMapping("/MedicalRecords/add")
    MedicalRecord newMedicalRecord(@RequestBody MedicalRecord newMedicalRecord) {
        return medicalRecordRepo.save(newMedicalRecord);
    }


    //get dossier medical par Id
    @GetMapping("/MedicalRecords/{id_medrec}")
    MedicalRecord getMedicalRecordById(@PathVariable Long id_medrec) {
        return medicalRecordRepo.findById(id_medrec).orElse(null);
    }

    @PutMapping("/MedicalRecords/update/{id_medrec}")
    public ResponseEntity<MedicalRecord> updateMedicalRecord(@PathVariable long id_medrec, @RequestBody MedicalRecord medRecordDetails) {
        MedicalRecord updateMedicalRecord = medicalRecordRepo.findById(id_medrec)
                .orElseThrow(null);

        updateMedicalRecord.setDatenaiss(medRecordDetails.getDatenaiss());
        updateMedicalRecord.setAppointmentTime(medRecordDetails.getAppointmentTime());
        updateMedicalRecord.setDiagnosis(medRecordDetails.getDiagnosis());
        updateMedicalRecord.setTreatment(medRecordDetails.getTreatment());
        updateMedicalRecord.setAppointmentDate((medRecordDetails.getAppointmentDate()));

        medicalRecordRepo.save(updateMedicalRecord);

        return ResponseEntity.ok(updateMedicalRecord);
    }

    //delete dossier medical by Id
    @DeleteMapping("/MedicalRecords/delete/{id_medrec}")
    public ResponseEntity<MedicalRecord> deleteMedicalRecord(@PathVariable long id_medrec) {
        medicalRecordRepo.deleteById(id_medrec);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/MedicalRecords/byDatenaiss/{datenaiss}")
    List<MedicalRecord> getMedicalRecordsByDatenaiss(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate datenaiss) {
        return medicalRecordRepo.findByDatenaiss(datenaiss);
    }

    @DeleteMapping("/MedicalRecords/deleteAll")
    public ResponseEntity<String> deleteAllMedicalRecords() {
        medicalRecordRepo.deleteAll();
        return new ResponseEntity<>("All medical records have been deleted.", HttpStatus.OK);
    }
}