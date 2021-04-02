package com.example.demo.configs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.AccountRoleEntity;
import com.example.demo.repositories.AccountRoleRepository;

@Service
public class accountroleService {
	@Autowired
	AccountRoleRepository accountRoleRepository;
	public void save1 (AccountRoleEntity hihi) {
		accountRoleRepository.save(hihi);
	}
}
