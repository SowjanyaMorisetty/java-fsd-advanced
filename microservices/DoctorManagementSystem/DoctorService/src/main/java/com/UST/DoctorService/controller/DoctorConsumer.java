package com.UST.DoctorService.controller;

import com.UST.DoctorService.model.DoctorDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "DoctorService")
public interface DoctorConsumer {


    @PostMapping("/doctor")
    public ResponseEntity<DoctorDetails> createDoctor(@RequestBody DoctorDetails doctorDetails);

    @GetMapping("/a/{id}")
    public ResponseEntity<DoctorDetails> getDoctorDetails(@PathVariable Integer id);

    @PutMapping("/update/{id}")
    public ResponseEntity<DoctorDetails> updateDoctorDetails(@RequestBody DoctorDetails details,@PathVariable Integer id);

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoctorDetails(@PathVariable Integer id);
//    @GetMapping("/doctors/{doctorId}")
//    DoctorDetails getDoctorById(@PathVariable("doctorId") Long doctorId);
}
