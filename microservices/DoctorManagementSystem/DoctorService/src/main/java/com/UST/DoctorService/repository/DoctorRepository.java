package com.UST.DoctorService.repository;

import com.UST.DoctorService.model.DoctorDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorDetails,Integer> {

}
