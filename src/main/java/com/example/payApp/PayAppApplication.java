package com.example.payApp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class PayAppApplication {
	private static Logger log = LogManager.getLogger(PayAppApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(PayAppApplication.class, args);
		
		log.info("Welcome To the Pay App enjoy your secure payment App");
		
		log.info("Use this link to fetch the swagger Documentation");
		
		log.info("http://localhost:8080/swagger-ui.html");
	}

}
