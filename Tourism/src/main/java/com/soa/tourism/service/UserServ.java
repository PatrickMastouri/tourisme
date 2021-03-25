package com.soa.tourism.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soa.tourism.model.LoginForm;
import com.soa.tourism.model.User;
import com.soa.tourism.repository.UserRepository;

@Service
@Transactional
public class UserServ implements UserService {
	
	@Autowired
 	public	UserRepository userRepository;

	@Override
	public Optional<User> authenticate(LoginForm loginForm) {
		System.out.print(userRepository.getUserByEmailAndPassword(loginForm.getUsername(), loginForm.getPassword()));
		return userRepository.getUserByEmailAndPassword(loginForm.getUsername(), loginForm.getPassword());
	}

	

	


	

}
