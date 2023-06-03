package com.UST.Patientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PatientserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientserviceApplication.class, args);
	}

}
