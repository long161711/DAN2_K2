package com.example.demo.repositories.NhanvienRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.entities.NhanVien.DiemdanhEntity;
import java.util.List;

public interface DiemdanhRepository extends CrudRepository<DiemdanhEntity, Integer> {
	 @Query(value ="select * from diemdanh where idnhanvien = ?1",nativeQuery = true)
	 public  List<DiemdanhEntity> manv(String Id);
	 
//	 @Query(value ="select count(idnhanvien) from diemdanh where idnhanvien = ?1 group by idnhanvien")
//	 public DiemdanhEntity dem(int id);
}