package com.tiwari.learning.service;

import java.util.List;

import com.tiwari.learning.model.Role;
import com.tiwari.learning.model.User;

public interface UserService {
	
	public User findByUsername(String username);
	
	public List<User> getAllUsers();
	
	public User registerUser(User user);
	
}
