package com.example.demo.configs.services.nhanvien;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.NhanVien.NhanVienEntity;
import com.example.demo.repositories.NhanvienRepository.NhanvienRepository;

@Service
public class nhanvienService {
	@Autowired
	NhanvienRepository nhanvienRepository;
	
	public List<NhanVienEntity> getall(){
		return (List<NhanVienEntity>) nhanvienRepository.findAll();
	}
	public NhanVienEntity mnv(String idnhanvien) {
		return nhanvienRepository.manv(idnhanvien);
	}
	public void save1(NhanVienEntity nhanvienentity) {
		nhanvienRepository.save(nhanvienentity);
	}
	public NhanVienEntity findOneById(Integer id) {
		return (NhanVienEntity) nhanvienRepository.findOneById(id);
		
	}
	public void xoa(NhanVienEntity nhanvienentity) {
		nhanvienRepository.delete(nhanvienentity);
	}
}
