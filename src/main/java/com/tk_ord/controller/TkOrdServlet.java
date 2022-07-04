package com.tk_ord.controller;


import java.io.*;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;
import com.movie.model.MovieService;
import com.showing.model.*;


@WebServlet("/tkOrd12/tkOrd.do")
public class TkOrdServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
	
		if ("listShowings_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
			 String[] MV_ID = {req.getParameter("MV_ID")};
			 String[] SH_TIME = {req.getParameter("SH_TIME")};

			 Map<String, String[]> map = new LinkedHashMap<String, String[]>();
			 map.put("MV_ID", MV_ID);
			 map.put("SH_TIME", SH_TIME);
			 
			 
			 ShowingService showingSvc = new ShowingService();
			 List<ShowingVO> list  = showingSvc.getAll(map);
			   
			 
			   PrintWriter out = res.getWriter();
			   Gson gson = new Gson();
			   out.print(gson.toJson(list));
			  }
		
			
	}
}
