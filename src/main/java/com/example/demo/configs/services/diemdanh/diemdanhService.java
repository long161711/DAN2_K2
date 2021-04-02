package com.example.demo.configs.services.diemdanh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.NhanVien.DiemdanhEntity;
import com.example.demo.repositories.NhanvienRepository.DiemdanhRepository;

@Service
public class diemdanhService {
	@Autowired
	DiemdanhRepository diemdanh;
	public void xoaall() {
		diemdanh.deleteAll();
	}
	public List<DiemdanhEntity> getAll(){
		return (List<DiemdanhEntity>) this.diemdanh.findAll();
	}
	public List<DiemdanhEntity> mnv(String manhanvien){
		return (List<DiemdanhEntity>) diemdanh.manv(manhanvien);
		
	}
}
