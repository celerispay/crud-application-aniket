package com.example.payApp.repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payApp.models.User;
import com.example.payApp.repository.UserRepository;

@Service
public class UserRepoServiceImpl implements UserRepoService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByName(String userName) {
		return userRepository.findByuname(userName);
	}

	@Override
	public String findRoleByName(String userName) {
		return  userRepository.findByuname(userName).getUrole();	
	}

}
