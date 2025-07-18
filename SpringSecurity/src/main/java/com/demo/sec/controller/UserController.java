package com.demo.sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sec.model.User;
import com.demo.sec.service.JwtService;
import com.demo.sec.service.UserService;

import jakarta.annotation.Resource;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtService jwtService;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		Authentication authentication = authenticationManager.authenticate(new 
				UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		
		if(authentication.isAuthenticated())
			return "Success";
		else
			return "Login failed";
	}

}
