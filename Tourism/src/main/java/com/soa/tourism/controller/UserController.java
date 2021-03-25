package com.soa.tourism.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.soa.tourism.model.LoginForm;
import com.soa.tourism.model.User;
import com.soa.tourism.service.UserService;
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	//login
	 @PostMapping("/Login")
	    @ResponseBody
	    public Optional<User> Login(@RequestBody LoginForm loginForm) {
		 ResponseTransfer S = new ResponseTransfer();
		 S.setText("rafik");
		 
		 Optional<User> u = userservice.authenticate(loginForm);
		 return u;
	     }
}
