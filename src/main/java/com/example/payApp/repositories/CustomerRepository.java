package com.example.payApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.payApp.models.Customer;
import com.example.payApp.models.User;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}