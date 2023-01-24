package com.example.payApp.controller;

<<<<<<< HEAD
import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.payApp.exception.CustomerNotFoundException;
import com.example.payApp.models.Customer;
import com.example.payApp.services.ICustomerService;
import com.mysql.cj.protocol.x.Ok;

import ch.qos.logback.classic.Logger;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
=======
import com.example.payApp.models.Customer;
import com.example.payApp.services.ICustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RestController
>>>>>>> 776206b (initial2 commit)
public class AppController {
	
	@Autowired
	private ICustomerService customerService;
	
	//For fetching the swagger Documentation http://localhost:8080/swagger-ui.html
	
	
	
	@PostMapping("/customer")
	public ResponseEntity<Long>addingCustomer(@Valid @RequestBody Customer customer){
		log.info("add customer called with {}", customer);
		Long idLong = customerService.addCustomers(customer);
		log.info("adding customer returned", idLong);
		return ResponseEntity.created(null).body(idLong);
	}
	
	
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> findingCustomerWithId(@PathVariable("id") Long id){
		log.info("finding doctor with id {}", id);
		Customer findedCustomer = customerService.findCustomerById(id);
		log.info("Detail of customer", findedCustomer);
		Model model;
		
		return ResponseEntity.ok().body(findedCustomer);
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer ,@PathVariable ("id") Long id){
		log.info("finding and upadteing with id", id);
		Customer updatedCustomer = customerService.updateCustomerById(customer, id);
		log.info("You are upadted now by Id" ,id);
		return ResponseEntity.ok().body(updatedCustomer);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("id") Long id){
		log.info("Deleting the customer with id {}", id);
		customerService.deleteCustomerById(id);
		log.info("customer deleted with id", id);
		return ResponseEntity.ok().body("Customer deleted successfully");
	}
	
}
