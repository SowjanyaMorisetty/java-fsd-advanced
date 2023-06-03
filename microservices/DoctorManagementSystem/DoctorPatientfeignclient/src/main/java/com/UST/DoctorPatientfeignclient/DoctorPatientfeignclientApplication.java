package com.UST.DoctorPatientfeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DoctorPatientfeignclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorPatientfeignclientApplication.class, args);
	}

}
