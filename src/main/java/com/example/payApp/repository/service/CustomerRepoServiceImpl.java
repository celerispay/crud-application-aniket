package com.example.payApp.repository.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payApp.exception.CustomerNotFoundException;
import com.example.payApp.models.Customer;
import com.example.payApp.repository.CustomerRepository;

@Service
public class CustomerRepoServiceImpl implements CustomerRepoService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
		
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(Long id) throws CustomerNotFoundException {
		Optional<Customer> optionalCusOptional = customerRepository.findById(id);
		if(!optionalCusOptional.isPresent()) {
			throw new CustomerNotFoundException("Please enter correct customerId, This Id "+ id + " is not present");
		}
		return optionalCusOptional.get();
	}

	@Override
	public Customer updateById(Customer customer, Long id)throws CustomerNotFoundException{

		Optional<Customer> optionalCusOptional = customerRepository.findById(id);
		if(!optionalCusOptional.isPresent()) {
			throw new CustomerNotFoundException("Please enter correct customerId, This Id "+ id + " is not present");
		}
		Customer cu = optionalCusOptional.get();
		cu.setCustomerName(customer.getCustomerName());
		cu.setCustomerPhoneNumber(customer.getCustomerPhoneNumber());
		cu.setCustomerEmail(customer.getCustomerEmail());
		cu.setCustomerCurrentBalance(customer.getCustomerCurrentBalance());
		cu.setCustomerPaymentMethod(customer.getCustomerPaymentMethod());
		return customerRepository.save(cu);
	}

	@Override
	public void deleteById(Long id)throws CustomerNotFoundException {

		customerRepository.deleteById(id);

	}

}
