package com.agency.models;

import java.time.LocalDate;


public class Reservation {

	private long id;
	private String client;
	private LocalDate in;
	private LocalDate out;
	private double amount;
	private Room room;
	private Hotel hotel;
	
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public LocalDate getIn() {
		return in;
	}
	public void setIn(LocalDate in) {
		this.in = in;
	}
	public LocalDate getOut() {
		return out;
	}
	public void setOut(LocalDate out) {
		this.out = out;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
		
	public Reservation(String client, LocalDate in, LocalDate out, double amount, Room room, Hotel hotel) {
		this.client = client;
		this.in = in;
		this.out = out;
		this.amount = amount;
		this.room = room;
		this.hotel = hotel;
	}
		
	
	public Reservation() {
		this.client = "null";
		this.in = LocalDate.parse("2000-01-01");
		this.out = LocalDate.parse("2000-01-01");
		this.amount = 0;
		this.hotel = new Hotel();
		this.room = new Room();
	}
	@Override
	public String toString() {
		return "Reservation : " + client + "room n°" + room + "\n"+
				"From " + in + " to " + out + "\n";
	}
}
