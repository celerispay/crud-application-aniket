package com.example.payApp.repository.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payApp.exception.CustomerNotFoundException;
import com.example.payApp.models.Customer;
import com.example.payApp.models.Upi;
import com.example.payApp.repository.CustomerRepository;
import com.example.payApp.repository.UpiRepository;

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
		upi.setUpiId(upi.getUpiId());
		upi.setCustomer(optionalCOptional.get());
		return upiRepository.save(upi);
	}

}
