package com.example.demo.Controller.Nhanvien;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.configs.services.nhanvien.nhanvienService;
//import com.example.demo.entities.AccountEntity;
import com.example.demo.entities.NhanVien.NhanVienEntity;
//import com.example.demo.repositories.NhanvienRepository.NhanvienRepository;


@Controller
public class NhanvienController {
//	@Autowired
//	NhanvienRepository nhanvienRepository;
	@Autowired
	nhanvienService nhanvienservice;
	@GetMapping (value = "/hienthinhanvien")
	public String hienthi(Model hi) {
//		List<NhanVienEntity> ab = (List<NhanVienEntity>) this.nhanvienRepository.findAll();
		List<NhanVienEntity> ab = nhanvienservice.getall();
		hi.addAttribute ("nhanvien",ab);
		return "layouts/admin/fragments/quanlynhanvien/hienthinhanvien";		
	}
	
	@GetMapping (value = "/them")
	@PreAuthorize(value="hasAuthority('Administrator')")
	public String them() {
		return "layouts/admin/fragments/quanlynhanvien/them";
	}
	@PostMapping(value = "/them")
	@PreAuthorize(value="hasAuthority('Administrator')")
	public String xacnhan (@ModelAttribute NhanVienEntity nhanvienentity , ModelMap map,Model c) {
//		AccountEntity alo = nhanvienRepository.findOneByHoten(nhanvienentity.getHoten());
//		if (alo != null) {
//            return "403";
//        }
//		else {}
		NhanVienEntity tim = nhanvienservice.mnv(nhanvienentity.getManv());
		if(tim!=null) {
			
			return new String("/layouts/admin/fragments/403");
		}
		else {
//			nhanvienRepository.save(nhanvienentity);
			nhanvienservice.save1(nhanvienentity);
//		List<NhanVienEntity> ab = (List<NhanVienEntity>) this.nhanvienRepository.findAll();
		List<NhanVienEntity> ab = nhanvienservice.getall();
		c.addAttribute ("nhanvien",ab);
		return "layouts/admin/fragments/quanlynhanvien/hienthinhanvien";
		}
	}
	private NhanVienEntity nhanvien;
	@GetMapping (value = "/sua/{id}")
	@PreAuthorize(value="hasAuthority('Administrator')")
	public String sua(@PathVariable(value="id") int id,ModelMap model) {
		//System.out.print(id);
//		nhanvien = (NhanVienEntity) nhanvienRepository.findOneById(id);
		nhanvien =nhanvienservice.findOneById(id);
		model.addAttribute("sua",nhanvien);
		
		return "layouts/admin/fragments/quanlynhanvien/sua";
	}
	 @PostMapping(value = "/sua")
	 @PreAuthorize(value="hasAuthority('Administrator')")
	 public String ss (@ModelAttribute NhanVienEntity nhanvienentity,ModelMap model,Model hi) {
		
//		 nhanvienRepository.save(nhanvienentity);
		 nhanvienservice.save1(nhanvienentity);
//		List<NhanVienEntity> ab = (List<NhanVienEntity>) this.nhanvienRepository.findAll();
		 List<NhanVienEntity> ab = nhanvienservice.getall();
		 hi.addAttribute ("nhanvien",ab);
		return "layouts/admin/fragments/quanlynhanvien/hienthinhanvien";	
		 
	 }
	 @GetMapping (value = "/xoa/{id}")
	 @PreAuthorize(value="hasAuthority('Administrator')")
	 public String xoa(@PathVariable(value="id") int id,ModelMap model) {
//			nhanvien = (NhanVienEntity) nhanvienRepository.findOneById(id);
			nhanvien =nhanvienservice.findOneById(id);
			model.addAttribute("xoa",nhanvien);
			
			return "layouts/admin/fragments/quanlynhanvien/xoa";
	 }
	 @PostMapping(value = "/xoa")
	 @PreAuthorize(value="hasAuthority('Administrator')")
	 public String xx (@ModelAttribute NhanVienEntity nhanvienentity,ModelMap model,Model hi) {
		 
		 nhanvienservice.xoa(nhanvienentity);
//		List<NhanVienEntity> ab = (List<NhanVienEntity>) this.nhanvienRepository.findAll();
		 List<NhanVienEntity> ab = nhanvienservice.getall();
		 hi.addAttribute ("nhanvien",ab);
		return "layouts/admin/fragments/quanlynhanvien/hienthinhanvien";	 
	 }
}
