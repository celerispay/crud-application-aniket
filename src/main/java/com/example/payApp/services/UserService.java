package com.example.payApp.services;

import com.example.payApp.models.User;

public interface UserService {
	  public User register(User user);
	  public User getDetails(String username);
	  public String getUserRoles(String username);
}
