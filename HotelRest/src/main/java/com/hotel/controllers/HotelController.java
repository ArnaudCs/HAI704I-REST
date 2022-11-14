package com.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.exceptions.HotelNotFoundException;
import com.hotel.models.Hotel;
import com.hotel.repositories.HotelRepository;

public class HotelController {
	
	@Autowired
	private HotelRepository repository;
	
	public List<Hotel> getAllHotels() {
		return repository.findAll();
	}
	
	public String count() {
		return String.format("{\"%s\": %d}", "count", repository.count());
	}
	
	public Hotel getHotelById(long id) throws HotelNotFoundException {
		return repository.findById(id).orElseThrow(() -> new HotelNotFoundException("Error ; could not found hotel by ID"));
	}
	
	public Hotel createHotel(Hotel hotel) {
		return repository.save(hotel);
	}
	
	public Hotel upodateHotel(Hotel newHotel, long id) {
		return repository.findById(id).map(hotel -> {
			hotel.setName(newHotel.getName());
			hotel.setStars(newHotel.getStars());
			hotel.setAddress(newHotel.getAddress());
			hotel.setRooms(newHotel.getRooms());
			hotel.setResa(newHotel.getResa());
			repository.save(hotel);
			return hotel;
		}).orElseGet(() -> {
			newHotel.setId(id);
			repository.save(newHotel);
			return newHotel;
		});
	}
	
	public void deleteEmployee(long id) {
		
	}
}
