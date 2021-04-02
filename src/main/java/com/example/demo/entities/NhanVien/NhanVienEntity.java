package com.example.demo.entities.NhanVien;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name ="nhanvien",schema = "longlong")
public class NhanVienEntity {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Integer id;
	 
	 @Column(name ="MaNV")
	 private String manv;
	 
	 public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	@Column(name = "hoten")
	 private String hoten;
	 
	 @Column(name= "ngaysinh")
	 private Date ngaysinh;

	 @Column(name = "gioitinh")
	 private String gioitinh;
	 
	 @Column(name ="chucvu")
	 private String chucvu;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh2) {
		this.ngaysinh = ngaysinh2;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getChucvu() {
		return chucvu;
	}

	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	 
	 
	 
	
}
