package com.agency.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	private RestTemplate proxy;
	@Autowired
	private AgencyRepository repository;
	private static final String uri = "hotelorg/api";
	
	
	@GetMapping(uri + "/agency")
	public List<Agency> getAllAgencies() {
		return repository.findAll();
	}
	
	@RequestMapping(
			  value = uri + "/agency/search",
			  params = { "position", "size", "rating", "datein", "dateout", "price" }, 
			  method = RequestMethod.GET)
	@ResponseBody
	public List<Hotel> searchHotel(@RequestParam("position") String position, @RequestParam("size") int size, @RequestParam("rating") double rating, 
			@RequestParam("datein") String datein, @RequestParam("dateout") String dateout, @RequestParam("price") double price) {
		Agency agence = repository.findAll().get(0);
		List<Hotel> toReturnHotels = new ArrayList<>();
		ArrayList<String> URIS = new ArrayList<>();
		for (Offers offer: agence.getOffers()) {
			URIS.add(offer.getUri());
		}
		Map<String, String> params = new HashMap<>();
		params.put("position", position);
		params.put("datein", datein);
		params.put("dateout", dateout);
		params.put("size", String.valueOf(size));
		params.put("rating", String.valueOf(rating));
		params.put("price", String.valueOf(price));
		for (String uri : URIS) {
			try {
				String url = uri + "/search?position={position}&size={size}&rating={rating}&datein={datein}&dateout={dateout}&price={price}";
				Hotel returnedHotel = proxy.getForObject(url, Hotel.class, params);
				if(!returnedHotel.getName().equals("Undefined")) {
					toReturnHotels.add(returnedHotel);						
				}
			}
			catch (Exception e) {
				continue;
			}
		}
	return toReturnHotels;
	}
}
