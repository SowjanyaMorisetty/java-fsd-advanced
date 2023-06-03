package com.UST.AppointmentService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDetails {


    private Integer patientId;

  //  @Column(name = "name")
    private String name;

    private String address;
    private String aadharNumber;
}
