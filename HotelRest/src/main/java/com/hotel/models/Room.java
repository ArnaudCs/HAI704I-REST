package com.hotel.models;

public class Room {
	private int roomNumber;
	private double price;
	private int size;
	
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public Room(int roomNumber, double price, int size) {
		this.roomNumber = roomNumber;
		this.price = price;
		this.size = size;
	}
	public Room() {
		this.roomNumber = 0;
		this.price = 0;
		this.size = 0;
	}
	
	@Override
	public String toString() {
		return "Room n°" + roomNumber + " [" + size + "] " + price + "€\n";
	}
	
	
}
