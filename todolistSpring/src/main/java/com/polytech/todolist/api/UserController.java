package com.polytech.todolist.api;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.polytech.todolist.models.Users;
import com.polytech.todolist.service.RegisterService;

@RestController
public class UserController {

	@Autowired
	RegisterService registerService;
	
	@PostMapping("/register")
	public int register(@RequestBody Users user) {
		String mdp=user.getPassword();
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String pass=passwordEncoder.encode(mdp);
	    
		Users newAcc=new Users(user.getUsername(),pass,user.getFirstname(),user.getLastname(),true);
		return registerService.register(newAcc);
	}
	
	@GetMapping("/getUser")
	public Optional<String> getUser(Principal p) {
        Optional<String> username = Optional.ofNullable(p.getName());
        return username;
    }
}
