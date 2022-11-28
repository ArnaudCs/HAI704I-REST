package com.hotel.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.agency.models",
		"com.agency.client",
		"com.agency.cli"
})
public class HotelAdvisorApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelAdvisorApplication.class, args);
	}

}
