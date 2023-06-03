package com.UST.DoctorService.controller;


import com.UST.DoctorService.model.DoctorDetails;
import com.UST.DoctorService.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")

public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/doctor")
    public ResponseEntity<DoctorDetails> createDoctor(@RequestBody DoctorDetails doctorDetails) {
        return new ResponseEntity<>(doctorRepository.save(doctorDetails), HttpStatus.CREATED);
    }

    @GetMapping("/a/{id}")
    public ResponseEntity<DoctorDetails> getDoctorDetails(@PathVariable Integer id) {
        //return ResponseEntity.ok(doctorRepository.findById(id),HttpStatus.ACCEPTED));
        Optional<DoctorDetails> optDoctorDetails = doctorRepository.findById(id);
        if (optDoctorDetails.isPresent()) {
            DoctorDetails details = optDoctorDetails.get();
            return new ResponseEntity<>(details, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DoctorDetails> updateDoctorDetails(@RequestBody DoctorDetails details,@PathVariable Integer id)
    {
        Optional<DoctorDetails> optional=doctorRepository.findById(id);
        if(optional.isPresent()) {
            DoctorDetails doctorDetails = optional.get();
            doctorDetails.setDoctorName(details.getDoctorName());
            doctorDetails.setDoctorAddress(details.getDoctorAddress());
            doctorDetails.setDepartment(details.getDepartment());

            return new ResponseEntity<>(doctorDetails, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoctorDetails(@PathVariable Integer id)
    {
        Optional<DoctorDetails> detailsOptional=doctorRepository.findById(id);
        if(detailsOptional.isPresent())
        {
            doctorRepository.deleteById(id);
            return new ResponseEntity<>("deleted",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


}
