package com.example.payApp.config;




import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.payApp.models.User;
import com.example.payApp.repositories.UserRepository;

import lombok.Data;






@Component
@Data
public class UserAuthenticationProvider implements AuthenticationProvider{
	
	private static Logger logger = LogManager.getLogger(UserAuthenticationProvider.class);
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		 String username = authentication.getName();
	     String password = authentication.getCredentials().toString();
	     User user = userRepository.findByuname(username);
	     if(user == null) {
	    	 throw new BadCredentialsException("Details not found");
	     }
	     if (encoder.matches(password, user.getPassword())) {
	            logger.info("Successfully Authenticated the user");
	            return new UsernamePasswordAuthenticationToken(username, password, getUserRoles(user.getUrole()));
	        } else {
	            throw new BadCredentialsException("Password mismatch");
	        }
	     
	}
	     
	     private List<GrantedAuthority> getUserRoles(String userRoles){
	         List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
	         String[] roles = userRoles.split(",");
	         for (String role : roles) {
	             logger.info("Role: " + role);
	             grantedAuthorityList.add(new SimpleGrantedAuthority(role.replaceAll("\\s+", "")));
	         }

	         return grantedAuthorityList;
	     }

	

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	

}
