package com.polytech.todolist.repository;

import java.util.List;

import com.polytech.todolist.models.Users;

public interface UserRepository {
	List<Users> findUsername(String username);
	int register(Users user);
}
