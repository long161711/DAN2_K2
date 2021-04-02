package com.example.demo.entities.NhanVien;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tongsobuoidiemdanh",schema = "longlong")
public class sobuoidiemdanhEntity {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Integer id;
	 
	 @Column(name = "idnhanvien")
	 private String idnhanvien;
	 
	 @Column(name= "hoten")
	 private String hoten;

	 @Column(name = "sobuoi")
	 private Integer sobuoi;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdnhanvien() {
		return idnhanvien;
	}

	public void setIdnhanvien(String idnhanvien) {
		this.idnhanvien = idnhanvien;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public Integer getSobuoi() {
		return sobuoi;
	}

	public void setSobuoi(Integer sobuoi) {
		this.sobuoi = sobuoi;
	}
}
