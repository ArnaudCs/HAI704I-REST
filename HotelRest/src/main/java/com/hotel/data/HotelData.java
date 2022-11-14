package com.hotel.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hotel.models.Hotel;
import com.hotel.repositories.HotelRepository;

@Configuration
public class HotelData {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Bean
	public CommandLineRunner initDatabase(HotelRepository repository) {
		return args -> {
			logger.info("Loading database with " + repository.save(new Hotel("Crowne Plaza", 4.7, null, null)));
			logger.info("Loading database with " + repository.save(new Hotel("Kyriad", 4.3, null, null)));
		};
	}
}
