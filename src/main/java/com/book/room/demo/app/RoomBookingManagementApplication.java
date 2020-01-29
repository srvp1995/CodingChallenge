package com.book.room.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.book.room.demo")
@EnableJpaRepositories("com.book.room.demo")
@EntityScan("com.book.room.demo.dto")
public class RoomBookingManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomBookingManagementApplication.class, args);
	}

}
