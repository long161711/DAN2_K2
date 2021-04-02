package com.example.demo.configs.services.diemdanh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.NhanVien.sobuoidiemdanhEntity;
import com.example.demo.repositories.NhanvienRepository.sobuoidiemdanhRepository;

@Service
public class sobuoidiemdanhService {
	@Autowired
	sobuoidiemdanhRepository sobuoi; 
	public void xoaall() {
		sobuoi.deleteAll();
	}
	public void save1(sobuoidiemdanhEntity sobuoidiemdanh) {
		sobuoi.save(sobuoidiemdanh);
	}
	public List<sobuoidiemdanhEntity> getAll(){
		return (List<sobuoidiemdanhEntity>) this.sobuoi.findAll();
	}
}
