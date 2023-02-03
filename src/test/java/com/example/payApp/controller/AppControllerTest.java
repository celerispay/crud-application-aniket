package com.example.payApp.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.intThat;

import java.net.URI;
import java.net.URL;

import org.apache.catalina.AsyncDispatcher;
import org.jboss.jandex.AnnotationTarget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.MediaType;

import com.example.payApp.PayAppApplication;
import com.example.payApp.models.Customer;
import com.example.payApp.services.CustomerServiceImpl;
import com.example.payApp.services.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(classes = {PayAppApplication.class})
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@AutoConfigureMockMvc
@DirtiesContext
@ActiveProfiles("test")
class AppControllerTest {
	private ObjectMapper objectMapper;
	
	private MockMvc mvc;
	@MockBean
	private CustomerService customerService;
	
	@InjectMocks
	private AppController appController;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@BeforeEach
	void setup() {
		objectMapper = new ObjectMapper();
		
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@DisplayName("This is for Adding customer with post method")
	@Test
	void testAddingCustomer() throws Exception {
		String uri = "/customer";
		Customer customer = new Customer("Aniket Kumar","9090909090","aniket@gmail.com", 10000, "Upi");
		
		String jsonString = objectMapper.writeValueAsString(customer);
		System.out.println(jsonString);
	
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonString)).andReturn();
		
		
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
	}
	@DisplayName("This is for finding customer with get method")
	@Test
	void testFindingCustomerWithId() throws Exception{
		//URI uri = UriComponentsBuilder.fromPath("/customer").queryParam("id", 1).build().toUri();
		
		String uri = "/customer/1";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
			      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	@DisplayName("This is for updating customer with put method")
	@Test
	void testUpdateCustomer() throws Exception {
		String uri = "/customer/1";
		Customer customer = new Customer("Aniket Kumar","8989090783","aniket@gmail.com", 10000, "Upi");
		String jsonString = objectMapper.writeValueAsString(customer);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonString)).andReturn();
		int status  = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
	}
	
	@DisplayName("This is for deleting customer with delete method")
	@Test
	void testDeleteCustomerById() throws Exception {
		String uri = "/customer/2";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	}

}
