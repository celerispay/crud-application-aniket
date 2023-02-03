package com.example.payApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payApp.models.Bank;
@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

}
