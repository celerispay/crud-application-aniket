package com.example.payApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.payApp.models.User;
import com.example.payApp.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		User user1 = new User();
		user1.setUname(user.getUname());
		user1.setPassword(encoder.encode(user.getPassword()));
		user1.setUrole(user.getUrole());
		return userService.register(user1);
	}
	
	@GetMapping("/userInfo")
	public User getUserInfo(@RequestParam("uname") String name) {
		return userService.getDetails(name);
	}
	
	@GetMapping("/userRoles")
	public String getUserRoleInfo(@RequestParam("uname") String name) {
		return userService.getUserRoles(name);
	}
}
