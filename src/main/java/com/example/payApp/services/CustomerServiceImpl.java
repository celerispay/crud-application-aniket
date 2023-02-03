package com.example.payApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.payApp.models.Customer;
import com.example.payApp.repositoyService.CustomerRepoService;



@Primary
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepoService customerRepoService;
	
	@Override
	public Long addCustomers(Customer customer) {
		
		Customer newCustomer = new Customer(customer.getCustomerId(), customer.getCustomerName(),customer.getCustomerPhoneNumber(),customer.getCustomerEmail(),customer.getCustomerCurrentBalance(),customer.getCustomerPaymentMethod());
		Customer genCustomer = customerRepoService.save(newCustomer);
		return genCustomer.getCustomerId();
		
	}
	

	@Override
	public Customer findCustomerById(Long id){
		
			Customer customer = customerRepoService.findById(id);
		return customer;
	}
	
	@Override
	public Customer updateCustomerById(Customer customer, Long Id){
		
		Customer  customer2 = customerRepoService.updateById(customer, Id);
		return customer2;
	}

	@Override
	public void deleteCustomerById(Long id){
		
		
			customerRepoService.deleteById(id);
		
	}


	

	

}
