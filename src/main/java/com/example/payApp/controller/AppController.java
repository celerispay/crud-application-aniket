package com.example.payApp.controller;

<<<<<<< HEAD
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.payApp.models.Card;
import com.example.payApp.models.Customer;
import com.example.payApp.models.Upi;
import com.example.payApp.services.CardService;
import com.example.payApp.services.CustomerService;
import com.example.payApp.services.UpiService;


<<<<<<< HEAD


@RestController
=======
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
>>>>>>> 49ca26d6527aa3ed344797aa826d56467dc6bf7e
public class AppController {
	private static Logger log = LogManager.getLogger(AppController.class);	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private UpiService upiService;
	
	//For fetching the swagger Documentation http://localhost:8080/swagger-ui.html
	
	
	
	
	
	@PostMapping("/customer")
	public ResponseEntity<Long>addingCustomer(@Valid @RequestBody Customer customer){
		log.info("add customer called with {}", customer);
		Long idLong = customerService.addCustomers(customer);
		log.info("adding customer returned", idLong);
		return ResponseEntity.created(null).body(idLong);
	}
	
	@PostMapping("/addCard/{id}")
	public ResponseEntity<Card>addCardEntity(@Valid @RequestBody Card card, @PathVariable("id") Long id){
		log.info("add card using customer Id", id);
		Card newCard = cardService.addCardDeatils(id,card);
		log.info("adding card returned", id);
		return ResponseEntity.created(null).body(newCard);
	}
	
	@PostMapping("/addUpi/{id}")
	public ResponseEntity<Upi> addUpiEntity(@Valid @RequestBody Upi upi, @PathVariable("id") Long id){
		log.info("add Upi using customer Id", id);
		Upi newUpi = upiService.addUpi(id, upi);
		log.info("adding upi returned", id);
		return ResponseEntity.created(null).body(newUpi);
	}
	
	
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> findingCustomerWithId(@PathVariable("id") Long id){
		log.info("finding doctor with id {}", id);
		Customer findedCustomer = customerService.findCustomerById(id);
		log.info("Detail of customer", findedCustomer);
		
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
