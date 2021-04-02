package com.example.demo.configs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.RoleEntity;
import com.example.demo.repositories.RoleRepository;
@Service
public class roleService{
	@Autowired
	RoleRepository roleRepository;
	
	public RoleEntity findOneByName (String roleName) {
		return roleRepository.findOneByName(roleName);
		
	}
	
}
