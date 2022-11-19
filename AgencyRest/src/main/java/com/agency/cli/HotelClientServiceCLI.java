package com.agency.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.agency.models.Hotel;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class HotelClientServiceCLI extends AbstractMain implements CommandLineRunner {

	@Autowired
	private RestTemplate proxy;
	private static String URI_HOTEL;
	private static String URI_HOTEL_ID;
	
	@Override
	public void run(String... args) throws Exception {
		BufferedReader inputReader;
		String userInput = "";
		try {
			inputReader = new BufferedReader(new InputStreamReader(System.in));
			setTestServiceUrl(inputReader);
			URI_HOTEL = SERVICE_URL + "/hotels";
			URI_HOTEL_ID = URI_HOTEL + "/{id}";
			do {
				menu();
				userInput = inputReader.readLine();
				processUserInput(inputReader, userInput, proxy);
			} while (!userInput.equals(QUIT));
			System.exit(0);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected boolean validServiceUrl() {
		return SERVICE_URL.equals("http://localhost:8080/hotelservice/api/");
	}

	@Override
	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quit.");
		builder.append("\n1. Get number of hotels");
		builder.append("\n2. Display all hotels");
		builder.append("\n3. Get hotel by ID");
		builder.append("\n4. Add new hotel");
		builder.append("\n5. Delete hotel by ID");
		builder.append("\n6. Update hotel");
		
		System.out.println(builder);
		
		
	}
	
	private void processUserInput(BufferedReader reader, String userInput, RestTemplate proxy) {
		Map<String, String> params = new HashMap<>();
		try {
			switch(userInput) {
			case "1":
				String uri = URI_HOTEL + "/count";
				ObjectMapper mapper = new ObjectMapper();
				String countStr = proxy.getForObject(uri, String.class);
				long count = (int)mapper.readValue(countStr, Map.class).get("count");
				System.out.println(String.format("There are %d hotels\n", count));
				break;
				
			case "2":
				uri = URI_HOTEL;
				Hotel[] hotels = proxy.getForObject(uri, Hotel[].class);
				System.out.println("Hotels:");
				Arrays.asList(hotels).forEach( System.out::println);
				System.out.println();
				break;
				
			case "3":
				uri = URI_HOTEL_ID;
				System.out.println("Hotel ID: ");
				int id = Integer.parseInt(reader.readLine());
				params.put("id", String.valueOf(id));
				Hotel hotel = proxy.getForObject(uri, Hotel.class, params);
				System.out.println(String.format("Hotel with ID %s: %s", id, hotel));
				System.out.println();
				break;
				
			case "4":
				uri = URI_HOTEL;
				System.out.println("Hotel infos:\nName: ");
				String name = reader.readLine();
				System.out.println("\nRating: ");
				double rating = Double.parseDouble(reader.readLine());
				System.out.println("\nAdress: ");
				String adr = reader.readLine();
				System.out.println("\nRooms: ");
				String rooms = reader.readLine();
				
				Hotel newHotel = new Hotel(name, rating, rooms, adr);
				Hotel returnedHotel = proxy.postForObject(uri, newHotel, Hotel.class);
				System.out.println("Successfully added hotel: \n" + returnedHotel.toString());
				break;
				
			case "5":
				uri = URI_HOTEL_ID;
				System.out.println("Hotel ID: ");
				id = Integer.parseInt(reader.readLine());
				params.put("id", String.valueOf(id));
				proxy.delete(uri, params);
				System.out.println("Successfully deleted\n");
				break;
				
			case "6":
				uri = URI_HOTEL_ID;
				System.out.println("Hotel ID: ");
				id = Integer.parseInt(reader.readLine());
				System.out.println("New name: ");
				name = reader.readLine();
				System.out.println("New Rating: ");
				rating = Double.parseDouble(reader.readLine());
				System.out.println("New adress: ");
				adr = reader.readLine();
				System.out.println("New rooms: ");
				rooms = reader.readLine();
				params.put("id", String.valueOf(id));
				newHotel = new Hotel(name, rating, rooms, adr);
				
				proxy.put(uri, newHotel, params);
				System.out.println("Update done successfully!\n");
				break;
				
			case QUIT:
				System.out.println("Bye bye...");
				return;
			default:
				System.err.println("Wrong input. Try again: ");
				return;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (HttpClientErrorException e) {
			System.err.println(e.getMessage());
			System.err.println("Please try a different ID.");
		}
	}

}
