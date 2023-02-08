package com.example.payApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payApp.models.Upi;

@Repository
public interface UpiRepository extends JpaRepository<Upi, Long>{
	
}
