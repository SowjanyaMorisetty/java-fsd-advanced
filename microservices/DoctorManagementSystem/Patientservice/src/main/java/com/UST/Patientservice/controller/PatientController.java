package com.UST.Patientservice.controller;

import com.UST.Patientservice.model.PatientDetails;
import com.UST.Patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/doctor")
    public ResponseEntity<PatientDetails> createPatient(@RequestBody PatientDetails patientDetails) {
        return new ResponseEntity<>(patientRepository.save(patientDetails), HttpStatus.CREATED);
    }

    @GetMapping("/a/{patientId}")
    public ResponseEntity<PatientDetails> getPatientDetails(@PathVariable Integer patientId) {
        //return ResponseEntity.ok(doctorRepository.findById(id),HttpStatus.ACCEPTED));
        Optional<PatientDetails> optDoctorDetails = patientRepository.findById(patientId);
        if (optDoctorDetails.isPresent()) {
            PatientDetails details = optDoctorDetails.get();
            return new ResponseEntity<>(details, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{patientId}")
    public ResponseEntity<PatientDetails> updatePatientDetails(@RequestBody PatientDetails patientDetails,@PathVariable Integer patientId)
    {
        Optional<PatientDetails> optional=patientRepository.findById(patientId);
        if(optional.isPresent()) {
            PatientDetails doctorDetails = optional.get();
            doctorDetails.setName(patientDetails.getName());
            doctorDetails.setAddress(patientDetails.getAddress());
            doctorDetails.setAadharNumber(patientDetails.getAadharNumber());

            return new ResponseEntity<>(patientDetails, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @DeleteMapping("/delete/{patientId}")
    public ResponseEntity<String> deletePatientDetails(@PathVariable Integer patientId)
    {
        Optional<PatientDetails> detailsOptional=patientRepository.findById(patientId);
        if(detailsOptional.isPresent())
        {
            patientRepository.deleteById(patientId);
            return new ResponseEntity<>("deleted",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


}
