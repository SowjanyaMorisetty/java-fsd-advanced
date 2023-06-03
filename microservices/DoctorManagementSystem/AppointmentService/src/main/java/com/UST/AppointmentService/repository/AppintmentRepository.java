package com.UST.AppointmentService.repository;

import com.UST.AppointmentService.model.AppointmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppintmentRepository extends JpaRepository<AppointmentDetails,Integer> {


}
