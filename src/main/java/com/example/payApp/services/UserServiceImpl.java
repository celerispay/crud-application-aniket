package com.example.payApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payApp.models.User;
import com.example.payApp.repositoyService.UserRepoService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepoService userRepoService;

	@Override
	public User register(User user) {
		
		User newUser = new User(user.getUname(),user.getPassword(),user.getUrole());
		return userRepoService.save(newUser);
	}

	@Override
	public User getDetails(String username) {
		
		return userRepoService.findByName(username);
	}

	@Override
	public String getUserRoles(String username) {
		
		return userRepoService.findRoleByName(username);
	}

	
}
