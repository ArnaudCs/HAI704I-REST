package com.hotel.exceptions;

public class HotelNotFoundException extends Exception{

	public HotelNotFoundException() {
		super();
	}
	
	public HotelNotFoundException(String msg) {
		super(msg);
	}
}
