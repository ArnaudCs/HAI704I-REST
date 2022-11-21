package com.hotel.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hotel.models.Hotel;
import com.hotel.models.Position;
import com.hotel.repositories.HotelRepository;

@Configuration
public class HotelData {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Bean
	public CommandLineRunner initDatabase(HotelRepository repository) {
		return args -> {
			
			Position p1 = new Position("Montpellier", "France", "rue du jeu de paume", 1);
			logger.info("Loading database with " + repository.save(new Hotel("Crowne Plaza", 4.7, "sefzfe", p1)));
		};
	}
}
