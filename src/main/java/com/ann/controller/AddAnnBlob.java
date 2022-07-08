package com.ann.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ann.model.AnnService;
import com.ann.model.AnnVO;

@WebServlet("/ann/AddAnnBlob")
public class AddAnnBlob extends HttpServlet{

	 private static final long serialVersionUID = 1L;

	 @Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
		 
	  response.setContentType("image/gif");
	  
	  AnnService annService = new AnnService();
	  
	  Integer ann_no = Integer.valueOf(request.getParameter("ann_no"));
	  
	  byte[] ann_picture = null;
	  if(ann_no !=null && ann_no !=0) {
	   AnnVO annVO = annService.getOneAnn(ann_no);
	   ann_picture = annVO.getAnn_picture();
	  }
	  response.getOutputStream().write(ann_picture);
	  response.getOutputStream().flush();
	  response.getOutputStream().close();
	 }
	
}
