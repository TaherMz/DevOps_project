package com.example.devopsproject.ctrls;

import com.example.devopsproject.entities.Appointment;
import com.example.devopsproject.repps.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepo;


    //Afficher la liste des Rv
    @GetMapping("/appointments/all")
    List<Appointment> getAllAppointments(){
        return appointmentRepo.findAll();
    }

    //Ajouter un RV
    @PostMapping("/appointments/add")
    Appointment newAppointment(@RequestBody Appointment newAppointment){
        return appointmentRepo.save(newAppointment);
    }

    //get RV par Id
    @GetMapping("/appointments/{id}")
    Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentRepo.findById(id).orElse(null);
    }



    //update appointment
    @PutMapping("/appointments/update/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable long id, @RequestBody Appointment appointmentDetails) {
        Appointment updateAppointment = appointmentRepo.findById(id)
                .orElseThrow(null);

        updateAppointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
        updateAppointment.setAppointmentTime(appointmentDetails.getAppointmentTime());
        updateAppointment.setFirstname(appointmentDetails.getFirstname());


        appointmentRepo.save(updateAppointment);

        return ResponseEntity.ok(updateAppointment);
    }


    //delete appointment by Id
    @DeleteMapping("/appointments/delete/{id}")
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable long id){
        appointmentRepo.deleteById(id);
        return new  ResponseEntity<>(HttpStatus.OK);
    }


    // Get appointments by firstname
    @GetMapping("/appointments/byFirstname/{firstname}")
    List<Appointment> getAppointmentsByFirstname(@PathVariable String firstname) {
        return appointmentRepo.findByFirstname(firstname);
    }


    @GetMapping("/appointments/byAppointmentDate/{appointmentDate}")
    List<Appointment> getAppointmentsByAppointmentDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate appointmentDate) {
        return appointmentRepo.findByAppointmentDate(appointmentDate);
    }

}
