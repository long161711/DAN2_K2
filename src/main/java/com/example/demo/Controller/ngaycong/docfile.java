package com.example.demo.Controller.ngaycong;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.text.DateFormat;

//import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.NhanVien.DiemdanhEntity;
//import com.example.demo.repositories.NhanvienRepository.DiemdanhRepository;
import java.text.SimpleDateFormat;
public class docfile {
//	@Autowired
//	DiemdanhRepository diemdanh;
	  static Connection getConnection() {
	        Connection con = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            String url, user, password;
	            url = "jdbc:mysql://localhost:3306/longlong";
	            user = "root";
	            password = "1234567890";
	            con = DriverManager.getConnection(url, user, password);
	        } catch (Exception ex) {
	            System.err.println("Ket noi that bai");
	        }
	        return con;
	    }
	 public static boolean validateNgaylam(String dob) {
	        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	        df.setLenient(false);
	        try {
	            df.parse(dob);
	            return true;
	        } catch (Exception ex) {
	            return false;
	        }
	    }
	 public int doc(File duongdan) throws NumberFormatException, IOException {
		  Connection con = null;
	      Statement statement = null;
//		 File f = new File(duongdan);
//		 FileReader fr = new FileReader(duongdan);
//		 BufferedReader br = new BufferedReader(fr);
	      BufferedReader br = null;
	      try {   
	    	br = new BufferedReader(new FileReader(duongdan));       

	            //System.out.println("Đọc nội dung file sử dụng phương thức readLine()");

//	            String textInALine;
//
//	            while ((textInALine = br.readLine()) != null) {
//	                System.out.println(textInALine);
//	                textInALine = br.readLine();
//	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("                   ngao               ");
	        } 
	      
	      
	      
		 String st;
		 int count = 0;
		 while((st=br.readLine())!=null) {
			 DiemdanhEntity ddett= new DiemdanhEntity();
			 int id = Integer.parseInt(st.substring(0,8));
			 String ngaylam = st.substring(8,18);
			 //System.out.print(id + "    "+ ngaylam);
			 
			  if (!validateNgaylam(ngaylam)) {
				  	System.out.print("Sai format ngay di lam \"" + ngaylam + "\"; ");
	            }
			  else {		  
				 try{//Date ngaydilam = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(ngaylam);
					 
					 	con = getConnection();
	                    String sql = "insert into diemdanh(idnhanvien,ngaylam) values('"+id+"','" + ngaylam +"')";
	                    statement = (Statement) con.createStatement();
	                    statement.executeUpdate(sql);
	                    statement.close();
	                    con.close();
//					  ddett.setIdnhanvien(id);
//					  ddett.setNgaylam(ngaylam);
//					  diemdanh.save(ddett);
					  count++;	
					  }
					  catch (Exception e) {
						 System.out.print("ngungu ");
					}
			  }
		 }
		 return count;
	 }
}
