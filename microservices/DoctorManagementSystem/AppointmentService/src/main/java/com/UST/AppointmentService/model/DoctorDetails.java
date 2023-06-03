package com.UST.AppointmentService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DoctorDetails {

    private Integer id;
    //@Column(name = "doctorName")
    private String doctorName;
    private String doctorAddress;
    private String department;


}
