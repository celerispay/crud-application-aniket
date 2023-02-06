package com.example.payApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customeOpenAPI() {
		return new OpenAPI()
				.components(new Components())
				.info(new Info()
						.title("Payapp Application Api")
						.description("This is Api documention for PayApp")
						.contact(new Contact().email("aniketkumar@celerispay.com"))
						.license(new License().name("WLP"))
						.version("1.0")
				);
	}

}
