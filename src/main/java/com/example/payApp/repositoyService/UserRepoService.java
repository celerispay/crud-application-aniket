package com.example.payApp.repositoyService;

import com.example.payApp.models.User;

public interface UserRepoService {
	public User save(User user);
	public User findByName(String userName);
	public String findRoleByName(String userName);
}
