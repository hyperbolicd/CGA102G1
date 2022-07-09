//package com.ann.controller;
//
//import java.io.*;
//import java.sql.*;
//import javax.servlet.*;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
//
//import com.ann.model.AnnService;
//
//@WebServlet("/ann/AnnBlob_Reader")
//@MultipartConfig
//public class AnnBlob_Reader extends HttpServlet { // 版本一
//	private static final long serialVersionUID = 1L;
//	
//	
//	public AnnBlob_Reader() {
//		
//	}
//	
//	Connection con;
//	public static final String theURL ="jdbc:mysql://localhost:3306/movietheater?serverTimezone=Asia/Taipei";
//	
//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//		doPost(req, res);
//	}
//	
//	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//		
//		res.setContentType("image/gif");
//		ServletOutputStream out = res.getOutputStream();
//		
//		try {
//			Statement stmt = con.createStatement();
//			String id = req.getParameter("ann_no");
//			System.out.println(id);
//			
//			ResultSet rs = stmt.executeQuery("SELECT ann_picture from announcement where ann_no = "+ id);
//			
//			if(rs.next()) {
//				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("ann_picture"));
//				byte[] buf = new byte[in.available()];
//				
//				in.read(buf);
//				out.write(buf);
//				out.close();
//				in.close();
//			}else {
//				InputStream in = getServletContext().getResourceAsStream("/back_end/ann/images/tomcat.png");
//				BufferedInputStream bf = new BufferedInputStream(in);
//				byte[] buf = new byte[bf.available()];
//				bf.read(buf);
//				out.write(buf);
//				out.close();
//				bf.close();
//			}
//			rs.close();
//			stmt.close();
//		}catch(Exception e) {
//			InputStream in = getServletContext()
//					.getResourceAsStream("ann/images/withe.jpg");
//			BufferedInputStream bf = new BufferedInputStream(in);
//			byte[] buf = new byte[bf.available()];
//			bf.read(buf);
//			out.write(buf);
//			out.close();
//			bf.close();
//			System.out.println(e);
//		}
//		
//		
//	}
//	
//	public void init() throws ServletException{
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection(theURL, "root", "password");
//		} catch (ClassNotFoundException e) {
//			throw new UnavailableException("Couldn't load JdbcOdbcDriver");
//		} catch (SQLException e) {
//			throw new UnavailableException("Couldn't get db connection");
//		}	
//	}
//	
//	public void destroy() {
//		try {
//			if (con != null)
//				con.close();
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
//	}	
//	
//}
//
//
////package com.ann.controller;
////
////import java.io.BufferedInputStream;
////import java.io.ByteArrayInputStream;
////import java.io.IOException;
////import java.io.InputStream;
////
////import javax.servlet.ServletException;
////import javax.servlet.ServletOutputStream;
////import javax.servlet.annotation.WebServlet;
////import javax.servlet.http.HttpServlet;
////import javax.servlet.http.HttpServletRequest;
////import javax.servlet.http.HttpServletResponse;
////
////import com.ann.model.AnnService;
////import com.ann.model.AnnVO;
////
////@WebServlet("/ann/ShowAnnBlob")
////public class ShowAnnBlob extends HttpServlet {
////	private static final long serialVersionUID = 1L;
////     
////	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////		response.setContentType("image/gif");
////		ServletOutputStream out = response.getOutputStream();
////		
////		Integer ann_no = Integer.valueOf(request.getParameter("ann_no"));
////		
////		AnnService annSvc = new AnnService();
////		AnnVO annVO = annSvc.getOneAnn(ann_no);
////		
////		byte[] photo = annVO.getAnn_picture();
////		
////		if(photo != null) { 
////			// 如果有照片
////			BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(photo));
////			byte[] buff = new byte[4 * 1024]; // 4k
////			int length;
////			while((length = in.read(buff)) != -1) {
////				out.write(buff, 0, length);
////			}
////			in.close();
////		}
////		else {
////			// 如果沒照片
////			InputStream in = getServletContext().getResourceAsStream("/back_end/ann/annNoPhoto.png");
////			byte[] buff = new byte[in.available()];
////			in.read(buff);
////			out.write(buff);
////		}
////		
////	}
////
////}
////
//
