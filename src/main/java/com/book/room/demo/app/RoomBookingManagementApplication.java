package com.book.room.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.book.room.demo")
public class RoomBookingManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomBookingManagementApplication.class, args);
	}

}
