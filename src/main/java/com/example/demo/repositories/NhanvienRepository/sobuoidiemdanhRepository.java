package com.example.demo.repositories.NhanvienRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.NhanVien.sobuoidiemdanhEntity;



public interface sobuoidiemdanhRepository extends CrudRepository<sobuoidiemdanhEntity, Integer> {
	 @Query(value ="select * from tongsobuoidiemdanh  where id = ?1",nativeQuery = true)
	 public sobuoidiemdanhEntity findOneById(int Id);
}