package com.agency.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.agency.models.Agency;
import com.agency.models.Hotel;
import com.agency.models.Offers;
import com.agency.repositories.AgencyRepository;


@RestController
public class AgencyController {
	
	@Autowired
	private AgencyRepository repository;
	@Autowired
	private RestTemplate proxy;
	private static final String uri = "agency/api";
	
	@GetMapping(uri + "/agency")
	public List<Agency> getAllAgencies() {
		return repository.findAll();
	}
	
	@RequestMapping(
			  value = uri + "/agency/{id}/search", 
			  params = { "position", "size", "rating", "datein", "dateout", "price" }, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<Hotel> searchHotel(@PathVariable long id, @RequestParam("position") String position, @RequestParam("size") int size, @RequestParam("rating") double rating, 
			@RequestParam("datein") String datein, @RequestParam("dateout") String dateout, @RequestParam("price") double price) {
		Agency agence = new Agency(id);
		List<Hotel> resultHotel = new ArrayList<>(); 
		Map<String, String> params = new HashMap<>();
		params.put("position", position);
		params.put("datein", String.valueOf(datein));
		params.put("dateout", String.valueOf(dateout));
		params.put("size", String.valueOf(size));
		params.put("rating", String.valueOf(rating));
		params.put("price", String.valueOf(price));
		
		ArrayList<String> uriList = new ArrayList<>();
		for (Offers offre : agence.getOffers()) {
			String uri = offre.getUri();
			String url = uri + "/search?position={position}&size={size}&rating={rating}&datein={datein}&dateout={dateout}&price={price}";
			Hotel returnedHotel = proxy.getForObject(url, Hotel.class, params);
			if(!returnedHotel.getName().equals("Undefined")) {
				uriList.add(uri);
				resultHotel.add(returnedHotel);				
			}
		}
		return resultHotel;
	}
}
