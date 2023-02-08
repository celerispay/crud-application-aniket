package com.example.payApp.repositoy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payApp.exception.CustomerNotFoundException;
import com.example.payApp.models.Customer;
import com.example.payApp.models.Upi;
import com.example.payApp.repositories.CustomerRepository;
import com.example.payApp.repositories.UpiRepository;

@Service
public class UpiRepoServiceImpl implements UpiRepoService{

	@Autowired
	private UpiRepository upiRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Upi save(Long id, Upi upi)throws CustomerNotFoundException {
		Optional<Customer> optionalCOptional = customerRepository.findById(id);
		if(!optionalCOptional.isPresent()) {
			throw new CustomerNotFoundException("Please enter correct customerId, This Id "+ id + " is not present");
		}
		Customer customer = optionalCOptional.get();
		Upi newUpi = new Upi(upi.getUpiId(),customer);
		return upiRepository.save(newUpi);
	}

}
