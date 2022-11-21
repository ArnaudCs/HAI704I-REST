package com.hotel.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Position {
	
	@Id
	@GeneratedValue
	@Column(name = "position_id")
	private long id;
	private String city;
	private String country;
	private String street;
	private int number;
	private String gps;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id")
	private Hotel hotel;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	public Position(String city, String country, String street, int number, String gps) {
		this.city = city;
		this.country = country;
		this.street = street;
		this.number = number;
		this.gps = gps;
	}
	
	public Position(String city, String country, String street, int number) {
		this.city = city;
		this.country = country;
		this.street = street;
		this.number = number;
	}
	
	public Position() {
		this.city = "None";
		this.country = "None";
		this.street = "None";
		this.number = 0;
		this.gps = "None";
	}
	
	public Position(String gps) {
		this.gps = gps;
	}
	
	@Override
	public String toString() {
		return "Position : " + number + ", " + street + ", " + city + ", " + country + "\n";
	}

	
}
