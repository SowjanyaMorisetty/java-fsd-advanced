package com.UST.DoctorService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctors")
public class DoctorDetails {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "doctorName")
    private String doctorName;
    private String doctorAddress;
    private String department;



}
