package com.example.payApp.repositoy.service;

import com.example.payApp.models.User;

public interface UserRepoService {
	public User save(User user);
	public User findByName(String userName);
	public String findRoleByName(String userName);
}
