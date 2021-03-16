package com.example.apptour.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apptour.models.User;
import com.example.apptour.services.UserService;

@RestController
//@RequestMapping("/user")
@RequestMapping("/api/v1/")
public class UserController {
	@Autowired
	UserService userService;
	
	//@GetMapping
	@GetMapping("/user")
	public ArrayList<User> getUsers(){
		
		return userService.getUsers();
				
	}
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		
		return this.userService.saveUser(user);
		
		
	}

}
