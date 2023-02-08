package com.example.payApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.payApp.models.Customer;
import com.example.payApp.repositoy.service.CustomerRepoService;



@Primary
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepoService customerRepoService;

	@Override
	public Long addCustomers(Customer customer) {
		Customer newCustomer = customerRepoService.save(customer);
		return newCustomer.getCustomerId();

	}


	@Override
	public Customer findCustomerById(Long id){
		return customerRepoService.findById(id);
	}

	@Override
	public Customer updateCustomerById(Customer customer, Long Id){
		return customerRepoService.updateById(customer, Id); 
	}

	@Override
	public void deleteCustomerById(Long id){
		customerRepoService.deleteById(id);
	}

}
