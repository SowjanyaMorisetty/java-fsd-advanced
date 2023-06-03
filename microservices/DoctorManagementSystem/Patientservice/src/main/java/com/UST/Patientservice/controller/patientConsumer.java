package com.UST.Patientservice.controller;

import com.UST.Patientservice.model.PatientDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "DoctorService")
public interface patientConsumer {


        @PostMapping("/doctor")
        public ResponseEntity<PatientDetails> createPatient(@RequestBody PatientDetails doctorDetails);

        @GetMapping("/a/{patientId}")
        public ResponseEntity<PatientDetails> getPatientDetails(@PathVariable Integer patientId);

        @PutMapping("/update/{patientId}")
        public ResponseEntity<PatientDetails> updatePatientDetails(@RequestBody PatientDetails details,@PathVariable Integer patientId);

        @DeleteMapping("/delete/{patientId}")
        public ResponseEntity<String> deletePatientDetails(@PathVariable Integer patientId);
}
