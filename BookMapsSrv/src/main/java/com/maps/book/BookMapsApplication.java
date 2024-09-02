package com.maps.book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMapsApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookMapsApplication.class, args);
		System.out.println("Server is Running");
	}
}
