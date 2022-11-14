package com.hotel.models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hotel {
	// Attributes
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private double stars;
	private ArrayList<Room> rooms;
	private Position address;
	private ArrayList<Reservation> resa;
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
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	public Position getAddress() {
		return address;
	}
	public void setAddress(Position address) {
		this.address = address;
	}
	public ArrayList<Reservation> getResa() {
		return resa;
	}
	public void setResa(ArrayList<Reservation> resa) {
		this.resa = resa;
	}
	public String getImageFolder() {
		return imageFolder;
	}
	public void setImageFolder(String imageFolder) {
		this.imageFolder = imageFolder;
	}
	
	public Hotel(String name, double stars, ArrayList<Room> rooms, Position address, ArrayList<Reservation> resa,
			String imageFolder) {
		this.name = name;
		this.stars = stars;
		this.rooms = rooms;
		this.address = address;
		this.resa = resa;
		this.imageFolder = imageFolder;
	}
	
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", stars=" + stars + ", rooms=" + rooms + ", address=" + address
				+ ", resa=" + resa + ", imageFolder=" + imageFolder + "]";
	}
	
	
	
	
}
