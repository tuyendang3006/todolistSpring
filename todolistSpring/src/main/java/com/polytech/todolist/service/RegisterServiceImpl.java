package com.polytech.todolist.service;

import com.polytech.todolist.models.Users;
import com.polytech.todolist.repository.UserRepository;

public class RegisterServiceImpl implements RegisterService {
	private UserRepository userRepository;
	public RegisterServiceImpl (UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	public int register(Users user) {
		return userRepository.register(user);	
	}

}
