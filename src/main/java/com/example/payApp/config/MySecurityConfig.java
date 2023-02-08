package com.example.payApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
	
	  @Autowired
	  private UserDetailsService userDetailsService;
	
	  @Bean
	    public DaoAuthenticationProvider authProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService);
	        authProvider.setPasswordEncoder(passwordEncoder());
	        return authProvider;
	    }
	  
	
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http	
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/userInfo").authenticated()
                .antMatchers("/register").permitAll()
        		.antMatchers("/userRole").hasAnyAuthority("ROLE_WRITE")
        		.antMatchers("/").hasAnyAuthority("ROLE_WRITE")
                .and()
                .formLogin().defaultSuccessUrl("/welcome", true)
                .and()
                .httpBasic();

        return http.build();
    }
    
    
    
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

