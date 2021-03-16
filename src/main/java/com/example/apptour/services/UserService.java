package com.example.apptour.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apptour.models.User;
import com.example.apptour.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public ArrayList<User> getUsers(){
		ArrayList<User> users;
		//return (ArrayList<User>) userRepository.findAll()
		users = (ArrayList<User>) userRepository.findAll();
		return users;
	}
	
	public User saveUser(User user) {
		
		user = userRepository.save(user);
		
		return user;
		
		
	}

}
