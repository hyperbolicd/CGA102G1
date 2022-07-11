package com.ann.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ann.model.AnnService;
import com.ann.model.AnnVO;

@WebServlet("/ann/ShowAnnBlob")
public class ShowAnnBlob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/gif");
		ServletOutputStream out = response.getOutputStream();
		
		Integer ann_no = Integer.valueOf(request.getParameter("ann_no"));
		
		AnnService annSvc = new AnnService();
		AnnVO annVO = annSvc.getOneAnn(ann_no);
		
		byte[] photo = annVO.getAnn_picture();
		
		if(photo != null) { 
			// 如果有照片
			BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(photo));
			byte[] buff = new byte[4 * 1024]; // 4k
			int length;
			while((length = in.read(buff)) != -1) {
				out.write(buff, 0, length);
			}
			in.close();
		}
		else {
			// 如果沒照片
			InputStream in = getServletContext().getResourceAsStream("/back_end/ann/annNoPhoto.png");
			byte[] buff = new byte[in.available()];
			in.read(buff);
			out.write(buff);
		}
		
	}

}

