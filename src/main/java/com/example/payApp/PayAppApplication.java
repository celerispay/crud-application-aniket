package com.example.payApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class PayAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayAppApplication.class, args);
		
		log.info("Welcome To the Pay App enjoy your secure payment App");
		
		log.info("Use this link to fetch the swagger Documentation");
		
		log.info("http://localhost:8080/swagger-ui.html");
	}

}
