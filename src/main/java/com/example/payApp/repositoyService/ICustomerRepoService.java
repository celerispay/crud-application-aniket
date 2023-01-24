package com.example.payApp.repositoyService;

import java.util.List;

import com.example.payApp.models.Customer;

public interface ICustomerRepoService {
	public Customer save(Customer customer);
	public List<Customer> findAll();
	public Customer findById(Long id);
	public Customer updateById(Customer customer,Long id);
	public void deleteById(Long id);
	
}
