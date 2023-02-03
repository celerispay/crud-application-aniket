package com.example.payApp.controller;

<<<<<<< HEAD
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
=======
import com.example.payApp.models.Customer;
import com.example.payApp.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 776206b (initial2 commit)
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestBody;

import com.example.payApp.models.Customer;
import com.example.payApp.services.CustomerService;

@Controller
=======
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/public")
>>>>>>> 776206b (initial2 commit)
public class ThymeleafController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/registration_form")
	public String showRegistrationForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "registration_form";
	}
	
	@PostMapping("/addCustomer")
	public String addingCustomer(@Valid @ModelAttribute  Customer customer, Model model){
		model.addAttribute("customer",customer);
		Long idLong = customerService.addCustomers(customer);
		return "display_form";
	}
}
