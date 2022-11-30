package com.comparator.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.comparator.models",
		"com.comparator.client",
		"com.comparator.cli",
})
public class ComparatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComparatorApplication.class, args);
	}

}
