package com.hotel.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Hotel {
	// Attributes
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	private String name;
	private double stars;
	@OneToMany(mappedBy="hotel")
	private Set<Room> rooms;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="address_id", referencedColumnName = "id")
	private Position address;
	@OneToMany(mappedBy="hotelResa")
	private Set<Reservation> resas;
	private String imageFolder;
	
	public Set<Reservation> getResas() {
		return resas;
	}
	public void setResas(Set<Reservation> resas) {
		this.resas = resas;
	}
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
				+ ", resa=" + resas + ", imageFolder=" + imageFolder + "]";
	}
	
	
	
	
}
