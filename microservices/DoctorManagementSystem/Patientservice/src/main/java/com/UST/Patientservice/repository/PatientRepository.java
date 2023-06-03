package com.UST.Patientservice.repository;

import com.UST.Patientservice.model.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientDetails,Integer> {
}
