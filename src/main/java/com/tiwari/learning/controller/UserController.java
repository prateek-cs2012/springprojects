package com.tiwari.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiwari.learning.model.Role;
import com.tiwari.learning.model.User;
import com.tiwari.learning.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/users/getall")
	public List<User> getAllusers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping("/user/register")
	public User registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
	
	@RequestMapping("/role/create")
	public Role createRole(Role role) {
		return null;
	}
	
}
