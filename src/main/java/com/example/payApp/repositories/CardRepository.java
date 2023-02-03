package com.example.payApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payApp.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{

}
