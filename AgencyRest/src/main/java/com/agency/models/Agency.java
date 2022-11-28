package com.agency.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Agency {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	private String agencyName;
	@OneToMany(mappedBy="agency", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Offers> offers;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public List<Offers> getOffers() {
		return offers;
	}
	public void setOffers(List<Offers> offers) {
		this.offers = offers;
	}

	
	public Agency(String agencyName, List<Offers> offers) {
		this.agencyName = agencyName;
		this.offers = offers;
	}
	public Agency() {
		this.agencyName = "Hotel name";
		this.offers = new ArrayList<Offers>(); 
	}
	
	public Agency(long id) {
		String choice = String.valueOf(id);
		switch (choice) {
		case "1":
			this.agencyName = "Hotels.com";
			this.offers = new ArrayList<Offers>();
			Offers o1 = new Offers(1, "http://localhost:8080/crowne/api/", 10, this);
			Offers o2 = new Offers(2, "http://localhost:8081/ritz/api/", 15, this);
			Offers o3 = new Offers(3, "http://localhost:8082/ibis/api/", 5, this);
			offers.add(o1);
			offers.add(o2);
			offers.add(o3);
			break;
		
		case "2":
			this.agencyName = "Expedia";
			this.offers = new ArrayList<Offers>();
			o1 = new Offers(1, "http://localhost:8083/formule/api/", 20, this);
			o2 = new Offers(2, "http://localhost:8081/ritz/api/", 12, this);
			o3 = new Offers(3, "http://localhost:8082/ibis/api/", 8, this);
			offers.add(o1);
			offers.add(o2);
			offers.add(o3);
			break;
			
		case "3":
			this.agencyName = "Expedia";
			this.offers = new ArrayList<Offers>();
			o1 = new Offers(1, "http://localhost:8080/formule/api/", 21, this);
			o2 = new Offers(2, "http://localhost:8081/ritz/api/", 9, this);
			o3 = new Offers(3, "http://localhost:8082/ibis/api/", 5, this);
			Offers o4 = new Offers(3, "http://localhost:8080crowne/api/", 11, this);
			offers.add(o1);
			offers.add(o2);
			offers.add(o3);
			break;
		}
		
	}
	
	public void quitAgency() {
		System.out.println("Thanks for using TripFinder\n Bye bye...");
		System.exit(0);
	}
	@Override
	public String toString() {
		return "Agency [agencyName=" + agencyName + ", offers=" + offers + "]";
	}
	

}
