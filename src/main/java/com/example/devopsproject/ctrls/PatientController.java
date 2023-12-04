package com.example.devopsproject.ctrls;

import com.example.devopsproject.entities.Patient;
import com.example.devopsproject.repps.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
    @Autowired
    private PatientRepository patientRepo;

    //Show all Patients
    @GetMapping("/patients/all")
    List<Patient> getAllPatients(){
        return patientRepo.findAll();
    }


    //Add patient
    @PostMapping("/patients/add")
    Patient newPatient(@RequestBody Patient newPatient){
        return patientRepo.save(newPatient);
    }

    //get patient by ID
    @GetMapping("/patients/{idp}")
    Patient getPatientById(@PathVariable Long idp) {
        return patientRepo.findById(idp).orElse(null);
    }


    @PutMapping("/patients/update/{idp}")
    public ResponseEntity<Patient> updatePatient(@PathVariable long idp, @RequestBody Patient patientDetails) {
        Patient updatePatient = patientRepo.findById(idp)
                .orElseThrow(null);

        updatePatient.setFirstnamep(patientDetails.getFirstnamep());
        updatePatient.setLastnamep(patientDetails.getLastnamep());
        updatePatient.setPhonep(patientDetails.getPhonep());
        updatePatient.setEmailp(patientDetails.getEmailp());
        updatePatient.setPasswordp((patientDetails.getPasswordp()));
        patientRepo.save(updatePatient);
        return ResponseEntity.ok(updatePatient);
    }


    //delete appointment by Id
    @DeleteMapping("/patients/delete/{idp}")
    public ResponseEntity<Patient> deletePatient(@PathVariable long idp){
        patientRepo.deleteById(idp);
        return new  ResponseEntity<>(HttpStatus.OK);
    }
}
