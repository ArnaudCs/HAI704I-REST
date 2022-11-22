package com.agency.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hotel {

	// Attributes
	private long id;
	private String name;
	private double stars;
	private Set<Room> rooms;
	private Position address;
	private Set<Reservation> resas;
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
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	public Position getAddress() {
		return address;
	}
	public void setAddress(Position address) {
		this.address = address;
	}
	public Set<Reservation> getResa() {
		return resas;
	}
	public void setResa(Set<Reservation> resa) {
		this.resas = resa;
	}
	public String getImageFolder() {
		return imageFolder;
	}
	public void setImageFolder(String imageFolder) {
		this.imageFolder = imageFolder;
	}
	
	public Hotel(String name, double stars, Set<Room> rooms, Position address, Set<Reservation> resa,
			String imageFolder) {
		this.name = name;
		this.stars = stars;
		this.rooms = rooms;
		this.address = address;
		this.resas = resa;
		this.imageFolder = imageFolder;
	}
	
	public Hotel(String name, double stars, Set<Room> rooms, Position address) {
		this.name = name;
		this.stars = stars;
		this.rooms = rooms;
		this.address = address;
	}
	
	
	public Hotel() {
		this.name = "Undefined";
		this.stars = 0;
		this.rooms = new HashSet<>();
		this.address = new Position();
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", stars=" + stars + ", rooms=" + rooms + ", address=" + address
				+ ", resa=" + resas.toString() + ", imageFolder=" + imageFolder + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, id, imageFolder, name, getResa(), rooms, stars);
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
				&& Objects.equals(getResa(), other.getResa()) && Objects.equals(rooms, other.rooms)
				&& Double.doubleToLongBits(stars) == Double.doubleToLongBits(other.stars);
	}
	
	
}
