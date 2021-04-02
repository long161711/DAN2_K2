package com.example.demo.repositories.NhanvienRepository;





import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.entities.NhanVien.NhanVienEntity;

public interface NhanvienRepository extends CrudRepository<NhanVienEntity, Integer> {
	 @Query(value ="select * from nhanvien  where id = ?1",nativeQuery = true)
	 public NhanVienEntity findOneById(int Id);
	 
	 @Query(value ="select * from nhanvien  where MaNV = ?1",nativeQuery = true)
	public NhanVienEntity manv(String hoten);
	

	

//	@Query(value="update nhanvien set hoten=?2,ngaysinh=?3,gioitinh=?4,chucvu=?5 where id=?1 ")
//	public NhanVienEntity update(Integer id, String hoten, Date ngaysinh, String gioitinh, String chucvu);


	
//	 @Query(value="update nhanvien set hoten=?2,ngaysinh=?3,gioitinh=?4,chucvu=?5 where id=?1 ")
//	 public void update(Integer id, String hoten, Date ngaysinh, String gioitinh, String chucvu);
	


	
}
