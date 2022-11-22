package com.hotel.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	private String client;
	@Column(name = "dateIn")
	private LocalDate in;
	@Column(name = "dateOut")
	private LocalDate out;
	private String cc;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="room_id", referencedColumnName = "id")
	private Room room;
	@ManyToOne
	@JoinColumn(name="hotel_id", nullable=false)
	private Hotel hotelResa;
	
	
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
