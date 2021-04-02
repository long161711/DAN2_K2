package com.example.demo.configs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.entities.AccountEntity;
import com.example.demo.repositories.AccountRepository;

@Service
public class accountService1 {
	@Autowired
	AccountRepository accountRepository;
	

	
	public AccountEntity findOneByEmail(String Email) {
		return accountRepository.findOneByEmail(Email);
	}
	public List<AccountEntity> getAll(){
		return (List<AccountEntity>) accountRepository.findAll();
		
	}
	public void save1 (AccountEntity hihi) {
		accountRepository.save(hihi);
	}
	public AccountEntity findOneByEmail1(String email) {
		return  accountRepository.findOneByEmail1(email);
		
	}
}
