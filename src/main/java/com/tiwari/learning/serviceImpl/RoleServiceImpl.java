package com.tiwari.learning.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tiwari.learning.model.Role;
import com.tiwari.learning.repository.RoleRepository;
import com.tiwari.learning.service.RoleService;

public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository rolesRepo;
	
	@Override
	public Role createRole(Role role) {
		return rolesRepo.save(role);
	}

}
