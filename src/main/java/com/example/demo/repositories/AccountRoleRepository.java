package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.AccountRoleEntity;

public interface AccountRoleRepository extends CrudRepository<AccountRoleEntity, Integer> {
    public List<AccountRoleEntity> findByAccountId(int accountId);
}
