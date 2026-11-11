package com.micro.servicesregistery;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServicesregisteryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesregisteryApplication.class, args);
	}

}
