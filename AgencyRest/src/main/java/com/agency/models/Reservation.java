package com.agency.models;

import java.time.LocalDate;


public class Reservation {

	private long id;
	private String client;
	private LocalDate in;
	private LocalDate out;
	private String cc;
	private Room room;
	
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
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
		
	public Reservation(String client, LocalDate in, LocalDate out, String cc, Room room) {
		this.client = client;
		this.in = in;
		this.out = out;
		this.cc = cc;
		this.room = room;
	}
		
	
	public Reservation() {
		this.client = "null";
		this.in = LocalDate.parse("2000-01-01");
		this.out = LocalDate.parse("2000-01-01");
		this.cc = "0000000000000000";
		this.room = new Room();
	}
	@Override
	public String toString() {
		return "Reservation : " + client + "room n°" + room + "\n"+
				"From " + in + " to " + out + "\n";
	}
}
