package com.example.payApp.services;

import com.example.payApp.models.Customer;

public interface CustomerService {
	public Long addCustomers(Customer customer);
	public Customer findCustomerById(Long id);
	public Customer updateCustomerById(Customer customer, Long Id);
	public void deleteCustomerById(Long id);

}
