package com.UST.AppointmentService.controller;


import com.UST.AppointmentService.model.AppointmentDetails;
import com.UST.AppointmentService.repository.AppintmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppintmentRepository appintmentRepository;

    @PostMapping("/doctor")
    public ResponseEntity<AppointmentDetails> createAppointment(@RequestBody AppointmentDetails appointmentDetails) {
        return new ResponseEntity<>(appintmentRepository.save(appointmentDetails), HttpStatus.CREATED);
    }

    @GetMapping("/a/{id}")
    public ResponseEntity<AppointmentDetails> getAppointmentDetails(@PathVariable Integer id) {
        //return ResponseEntity.ok(doctorRepository.findById(id),HttpStatus.ACCEPTED));
        Optional<AppointmentDetails> optionalAppointmentDetails = appintmentRepository.findById(id);
        if (optionalAppointmentDetails.isPresent()) {
            AppointmentDetails details = optionalAppointmentDetails.get();
            return new ResponseEntity<>(details, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AppointmentDetails> updateAppointmentDetails(@RequestBody AppointmentDetails appointmentDetails,@PathVariable Integer id)
    {
        Optional<AppointmentDetails> optional=appintmentRepository.findById(id);
        if(optional.isPresent()) {
            AppointmentDetails appointmentDetails1 = optional.get();
            appointmentDetails1.setDoctor(appointmentDetails.getDoctor());
            appointmentDetails1.setPatient(appointmentDetails.getPatient());
            //appointmentDetails1.setAadharNumber(appointmentDetails.getAadharNumber());

            return new ResponseEntity<>(appointmentDetails1, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAppointmentDetails(@PathVariable Integer id) {
        Optional<AppointmentDetails> detailsOptional = appintmentRepository.findById(id);
        if (detailsOptional.isPresent()) {
            appintmentRepository.deleteById(id);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    }


}
