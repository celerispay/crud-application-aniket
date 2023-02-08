package com.example.payApp.repositoy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payApp.exception.CustomerNotFoundException;
import com.example.payApp.models.Card;
import com.example.payApp.models.Customer;
import com.example.payApp.repository.CardRepository;
import com.example.payApp.repository.CustomerRepository;

@Service
public class CardRepoServiceImpl implements CardRepoService{
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Card save(Long id,Card card)throws CustomerNotFoundException {
		Optional<Customer> optionalCusOptional = customerRepository.findById(id);
		if(!optionalCusOptional.isPresent()) {
			throw new CustomerNotFoundException("Please enter correct customerId, This Id "+ id + " is not present");
		}
		card.setNumber(card.getNumber());
		card.setExpMonth(card.getExpMonth());
		card.setExpYear(card.getExpYear());
		card.setCvv(card.getCvv());
		card.setCustomer(optionalCusOptional.get());
		return cardRepository.save(card);
	}

}
