package com.agency.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agency.models.Agency;
import com.agency.repositories.AgencyRepository;

@RestController
public class AgencyController {
	
	@Autowired
	private AgencyRepository repository;
	private static final String uri = "agency/api";
	
	@GetMapping(uri + "/agency")
	public List<Agency> getAllAgencies() {
		return repository.findAll();
	}
	
//	@RequestMapping(
//			  value = uri + "/agency/{id}/search", 
//			  params = { "position", "size", "rating", "datein", "dateout", "price" }, 
//			  method = RequestMethod.GET)
//	@ResponseBody
//	public Hotel searchHotel(@RequestParam("position") String position, @RequestParam("size") int size, @RequestParam("rating") double rating, 
//			@RequestParam("datein") String datein, @RequestParam("dateout") String dateout, @RequestParam("price") double price) {
//	
//	}
}
