package com.example.payApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payApp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findByuname(String userName);
}
