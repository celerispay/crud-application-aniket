package com.example.payApp.repository.service;

import java.util.List;

import com.example.payApp.models.Customer;

public interface CustomerRepoService {
	public Customer save(Customer customer);
	public List<Customer> findAll();
	public Customer findById(Long id);
	public Customer updateById(Customer customer,Long id);
	public void deleteById(Long id);
	
}
