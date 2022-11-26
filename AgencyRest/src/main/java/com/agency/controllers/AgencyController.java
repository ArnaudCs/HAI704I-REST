package com.agency.controllers;

import java.io.BufferedReader;
import java.time.LocalDate;

import com.agency.exceptions.ReservationException;
import com.agency.models.Hotel;
import com.agency.models.Reservation;
import com.agency.models.Room;

public class AgencyController {
	
	public static Reservation makeReservation(BufferedReader reader, LocalDate in, LocalDate out, Room room, Hotel hotel, double amount) throws ReservationException {
		Reservation resa = null;
		try {
			System.out.println("Firstname : ");
			String firstname = reader.readLine();
			System.out.println("Name : ");
			String name = reader.readLine();
//			System.out.println("E-mail : ");
//			String mail = reader.readLine();
//			System.out.println("Phone number : ");
//			String phone = reader.readLine();
//			System.out.println("Card number : ");
//			String num = reader.readLine();
//			System.out.println("CVV number : ");
//			String cvv = reader.readLine();
//			System.out.println("Expiration date (yyyy-mm-dd) : ");
//			LocalDate exp = LocalDate.parse(reader.readLine());
			resa = new Reservation(firstname + " " + name, in, out, amount, room, hotel);
			System.out.println("Your order have been placed. Thank you for your purchase !\n");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return resa;
	}
}
