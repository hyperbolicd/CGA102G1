package test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/PhotoString")
@MultipartConfig()
public class PhotoString extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		
//		response.setContentType("text/html; charset=utf-8;");
//		PrintWriter out = response.getWriter();
		
		String fileName = request.getParameter("fileName");
		Part part = request.getPart("photo");
		
		String uploadFileName = part.getSubmittedFileName();
		String fileEx = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
//		out.print("partName: " + uploadFileName);
//		out.print("partEx: " + fileEx);
		
		String filePath = getServletContext().getRealPath("/testPhoto");
		File fileDir = new File(filePath);
//		out.print("XXXXX___" + getServletContext().getRealPath("/testPhoto") + "______");
//		out.print("EXIST??" + !fileDir.exists());
		if(!fileDir.exists()) {
			boolean result = fileDir.mkdirs();
//			out.print("MKDIR??" + result);
		}
		
		String fileUpload = filePath + "/" + fileName + "." + fileEx;
//		out.print("SSSSSSSSS:" + fileUpload);
		part.write(fileUpload);
		
		String imgPath = request.getContextPath() + "/testPhoto/" + fileName + "." + fileEx;
		request.setAttribute("imgPath", imgPath);
		
		request.getRequestDispatcher("/PhotoPrint.jsp").forward(request, response);
	
	}

}
