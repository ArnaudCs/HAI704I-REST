package com.agency.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.agency.models",
		"com.agency.client",
		"com.agency.cli"
})
public class AgencyRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgencyRestApplication.class, args);
	}

}
