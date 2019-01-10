package com.tiwari.learning.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tiwari.learning.model.Role;
import com.tiwari.learning.model.User;
import com.tiwari.learning.repository.RoleRepository;
import com.tiwari.learning.repository.UserRepository;
import com.tiwari.learning.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleRepository  roleRepo;
	
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User registerUser(User user) {
		String rawPassword=user.getPassword();
		user.setPassword(passwordEncoder.encode(rawPassword));
		Role role=new Role();
		role.setName("admin");
		role.setDescription("Admin Role");
		roleRepo.save(role);
		user.setLastPasswordResetDate(new Date());
		List<Role> roles=new ArrayList<>();
		roles.add(role);
		user.setRoles(roles);
		return userRepo.save(user);
	}

}
