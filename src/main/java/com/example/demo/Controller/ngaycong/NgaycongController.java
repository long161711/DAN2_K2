package com.example.demo.Controller.ngaycong;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.example.demo.configs.services.nhanvien.nhanvienService;
//import com.example.demo.Controller.ngaycong.docfile;
import com.example.demo.configs.services.diemdanh.diemdanhService;
import com.example.demo.configs.services.diemdanh.sobuoidiemdanhService;
import com.example.demo.entities.NhanVien.DiemdanhEntity;
import com.example.demo.entities.NhanVien.NhanVienEntity;
import com.example.demo.entities.NhanVien.sobuoidiemdanhEntity;
//import com.example.demo.repositories.NhanvienRepository.DiemdanhRepository;
//import com.example.demo.repositories.NhanvienRepository.NhanvienRepository;
//import com.example.demo.repositories.NhanvienRepository.sobuoidiemdanhRepository;
@Controller
public class NgaycongController {
//	@Autowired
//	DiemdanhRepository diemdanh;
	@Autowired
	diemdanhService diemdanhservice;
//	@Autowired
//	NhanvienRepository nhanvienRepository;
	@Autowired
	nhanvienService nhanvienservice;
//	@Autowired
//	sobuoidiemdanhRepository sobuoi; 
	@Autowired
	sobuoidiemdanhService sobuoidiemdanhservice;
	@GetMapping(value= "/docfilettxt")
	public String tinhngaydilam() {
		return "/layouts/admin/fragments/tinhcongdilam/docfiletxt";
	}
	@PostMapping(value = "/hienthifile")
	public String docfile(@RequestParam("duongdan") File duongdan, Model model) throws IOException {
		diemdanhservice.xoaall();
		sobuoidiemdanhservice.xoaall();
		System.out.print("       +    " + duongdan);
		docfile doc =new docfile();
		if(doc.doc(duongdan)!=0) {
			System.out.print("       +    " + duongdan);
//			List<DiemdanhEntity> aa = (List<DiemdanhEntity>) this.diemdanh.findAll();
			List<DiemdanhEntity> aa =diemdanhservice.getAll();
			model.addAttribute("long", aa);
			return "/layouts/admin/fragments/tinhcongdilam/hienthifile";
	
		}
		else {
			return "/layouts/admin/fragments/tinhcongdilam/docfiletxt";
		}
		}
	@GetMapping(value= "/xacnhantongngaydilam")
	public String tinhtongngaydilam(Model model) {
//		List<NhanVienEntity> aa = (List<NhanVienEntity>) this.nhanvienRepository.findAll();
		List<NhanVienEntity> aa = nhanvienservice.getall();
		System.out.print("ngu                          ngu");
		for(NhanVienEntity s : aa) {
			sobuoidiemdanhEntity alo = new sobuoidiemdanhEntity();
			alo.setIdnhanvien(s.getManv());
			alo.setHoten(s.getHoten());
//			List<DiemdanhEntity> hih =   (List<DiemdanhEntity>) diemdanh.manv(s.getManv());
			List<DiemdanhEntity> hih =diemdanhservice.mnv(s.getManv());
			int i=0;
			for(DiemdanhEntity h : hih) {
				i++;
			}
			alo.setSobuoi(i);
//			sobuoi.save(alo);
			sobuoidiemdanhservice.save1(alo);
		}
//		List<sobuoidiemdanhEntity> bb = (List<sobuoidiemdanhEntity>) this.sobuoi.findAll();
		List<sobuoidiemdanhEntity> bb =sobuoidiemdanhservice.getAll();
		model.addAttribute("xuat",bb);
		return "/layouts/admin/fragments/tinhcongdilam/tongngaydilam";
	}
}
