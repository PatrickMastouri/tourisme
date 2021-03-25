package com.soa.tourism.service;

import java.util.Optional;

import com.soa.tourism.model.LoginForm;
import com.soa.tourism.model.User;


public interface UserService {
	
	public Optional<User> authenticate(LoginForm loginForm);

}
