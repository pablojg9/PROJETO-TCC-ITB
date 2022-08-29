package com.itb.tcc.amazbook.amazbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class AmazBookApplication {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println("Data => " + localDate);
		SpringApplication.run(AmazBookApplication.class, args);
	}

}
