package com.tiwari.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiwari.learning.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
