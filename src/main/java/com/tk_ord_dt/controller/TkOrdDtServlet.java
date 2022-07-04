package com.tk_ord_dt.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.tk_inf.model.TkInfService;

@WebServlet("/back_end/tk_ord_dt/tk_ord_dt.do")
public class TkOrdDtServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
    if ("transfer".equals(action)) { // 來自addTkInf.jsp的請求  
		
		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
		req.setAttribute("errorMsgs", errorMsgs);

			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			String tkType = req.getParameter("tkType");
			String tkTypeReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (tkType == null || tkType.trim().length() == 0) {
				errorMsgs.put("tkType","票種名稱: 請勿空白");
			} else if(!tkType.trim().matches(tkTypeReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("tkType","票種名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}
		
			Integer tkPrice = null;
			try {
				tkPrice = Integer.valueOf(req.getParameter("tkPrice").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("tkPrice","票價請填數字");
			}
			java.lang.Byte tkDI = java.lang.Byte.valueOf(req.getParameter("tkDI"));
			
			String tkTypeDT = req.getParameter("tkTypeDT").trim();
			


			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/tk_inf/addTkInf.jsp");
				failureView.forward(req, res);
				return;
			}
			
			/***************************2.開始新增資料***************************************/
			TkInfService tkInfSvc = new TkInfService();
			tkInfSvc.addTkInf(tkType, tkPrice, tkDI, tkTypeDT);
			
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/back_end/tk_inf/allTkInf.jsp";
			
			
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交allTkInf.jsp
			successView.forward(req, res);				
	}

}
}
