package com.UST.AppointmentService.model;
//import com.UST.Doctorservice.model.DoctorDetails;
//import com.UST.Patientservice.model.PatientDetails;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class AppointmentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id")
    private DoctorDetails doctor;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private PatientDetails patient;


}

