package com.example.payApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.payApp.models.User;
import com.example.payApp.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User user = userRepository.findByuname(username);
		 if (user == null) {
	            throw new UsernameNotFoundException(username);
	        }
	        return org.springframework.security.core.userdetails.User.withUsername(user.getUname())
	                            .password(user.getPassword())
	                            .authorities("USER").build(); 
	}

}
