package com.agency.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hotel {

	private long id;
	private String name;
	private double stars;
	private String rooms;
	private String address;
	private String resa;
	private String imageFolder;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getStars() {
		return stars;
	}
	public void setStars(double stars) {
		this.stars = stars;
	}
	public String getRooms() {
		return rooms;
	}
	public void setRooms(String rooms) {
		this.rooms = rooms;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getResa() {
		return resa;
	}
	public void setResa(String resa) {
		this.resa = resa;
	}
	public String getImageFolder() {
		return imageFolder;
	}
	public void setImageFolder(String imageFolder) {
		this.imageFolder = imageFolder;
	}
	
	public Hotel(String name, double stars, String rooms, String address, String resa, String imageFolder) {
		this.name = name;
		this.stars = stars;
		this.rooms = rooms;
		this.address = address;
		this.resa = resa;
		this.imageFolder = imageFolder;
	}
	
	public Hotel(String name, double stars, String rooms, String address) {
		this.name = name;
		this.stars = stars;
		this.rooms = rooms;
		this.address = address;
		this.imageFolder = "null";
		this.resa = "null";
	}
		
	public Hotel() {
		this.name = "none";
		this.stars = 0;
		this.rooms = "none";
		this.address = "none";
		this.imageFolder = "none";
		this.resa = "none";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, id, imageFolder, name, resa, rooms, stars);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return Objects.equals(address, other.address) && id == other.id
				&& Objects.equals(imageFolder, other.imageFolder) && Objects.equals(name, other.name)
				&& Objects.equals(resa, other.resa) && Objects.equals(rooms, other.rooms)
				&& Double.doubleToLongBits(stars) == Double.doubleToLongBits(other.stars);
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", stars=" + stars + ", rooms=" + rooms + ", address=" + address
				+ ", resa=" + resa + ", imageFolder=" + imageFolder + "]";
	}
	
	
}
