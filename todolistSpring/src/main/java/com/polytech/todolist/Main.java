package com.polytech.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {

	public static void main(String[] args) {
	      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	      System.out.println(passwordEncoder.encode("tuyen1994"));      
	}

}
