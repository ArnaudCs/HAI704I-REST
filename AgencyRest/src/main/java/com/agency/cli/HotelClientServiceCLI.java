package com.agency.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.web.ServerProperties.Jetty.Threads;
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
			URI_HOTEL = SERVICE_URL + "hotels";
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
		return SERVICE_URL.equals("http://localhost:8080/hotelservice/api");
	}

	@Override
	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quit.");
		builder.append("\n1. See all hotels");
		builder.append("\n2. Get hotel by ID");
		builder.append("\n3. Search hotel");
		builder.append("\n4. Make reservation");
		
		System.out.println(builder);
		
		
	}
	
	private void processUserInput(BufferedReader reader, String userInput, RestTemplate proxy) {
		Map<String, String> params = new HashMap<>();
		try {
			switch(userInput) {
			case "1":
				String uri = URI_HOTEL;
				Hotel[] hotels = proxy.getForObject(uri, Hotel[].class);
				System.out.println("Hotels:");
				Arrays.asList(hotels).forEach( System.out::println);
				System.out.println();
				break;

			case "2":
				uri = URI_HOTEL_ID;
				System.out.println("Hotel ID: ");
				int id = Integer.parseInt(reader.readLine());
				params.put("id", String.valueOf(id));
				Hotel hotel = proxy.getForObject(uri, Hotel.class, params);
				System.out.println(String.format("Hotel with ID %s: %s", id, hotel));
				System.out.println();
				break;
				
			case "3":
				uri = URI_HOTEL + "/search?position={position}&size={size}&rating={rating}&datein={datein}&dateout={dateout}&price={price}";
				System.out.println("Where do you want to go ? (City or country)\n");
				String position = reader.readLine();
				System.out.println("\nRating: ");
				double rating = Double.parseDouble(reader.readLine());
				System.out.println("\nPrice: ");
				double price = Double.parseDouble(reader.readLine());
				System.out.println("\nDate in: ");
				String inDate = reader.readLine();
				System.out.println("\nDate out: ");
				String outDate = reader.readLine();
				System.out.println("\nNumber of persons: ");
				int size = Integer.parseInt(reader.readLine());
				params.put("position", position);
				params.put("datein", inDate);
				params.put("dateout", outDate);
				params.put("size", String.valueOf(size));
				params.put("rating", String.valueOf(rating));
				params.put("price", String.valueOf(price));
				
				Hotel returnedHotel = proxy.getForObject(uri, Hotel.class, params);
				System.out.println("Results:\n");
				System.out.println(returnedHotel.toString());
				break;
				
			case "4":
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
