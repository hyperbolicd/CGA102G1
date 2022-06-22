package com.merchandise_order.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.naming.java.javaURLContextFactory;

import com.merchandise_inf.model.MerchService;
import com.merchandise_inf.model.MerchVO;
import com.merchandise_order.model.MerchOrdService;
import com.merchandise_order.model.MerchOrdVO;

@WebServlet("/MerchOrdServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class MerchOrdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MerchOrdServlet() {
        super();
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		String action = req.getParameter("action");
		
		if("getAll_For_Display".equals(action)) {
			MerchOrdService merchOrdSvc = new MerchOrdService();
			List<MerchOrdVO> list = merchOrdSvc.getAll();
			HttpSession session = req.getSession();
			session.setAttribute("merchOrdlist", list);
			String url = "???";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		if("getOne_For_Display".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);
			MerchOrdVO merchOrdVo = null;
			List<MerchOrdVO> list = null;
			/*==================================接收請求參數===========================*/
			try {
				Integer merchOrdID = Integer.valueOf(req.getParameter("merchOrdID"));
				
			/*==================================開始查詢資廖===========================*/
				MerchOrdService merchOrdSvc = new MerchOrdService();
				MerchOrdVO MerchOrdVo = merchOrdSvc.getOneMerchOrd(merchOrdID);
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
			if(merchOrdVo == null) {
				errorMsgs.put("merchID", "查無資料");
			}
			if(!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("????");
				failureView.forward(req, res);
				return;
			}
			/*===========================查詢完成,準備轉交==========================*/
			req.setAttribute("merchOrdVo", merchOrdVo);
			RequestDispatcher successView = req.getRequestDispatcher("????");
			successView.forward(req, res);
		}
		if("getOne_For_Update".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);
			/*=========================接收請求參數====================================*/
			Integer merchOrdID = Integer.valueOf(req.getParameter("merchOrdID"));
			/*=========================開始查詢資料====================================*/
			MerchOrdService merchOrdSvc = new MerchOrdService();
			MerchOrdVO merchOrdVo = merchOrdSvc.getOneMerchOrd(merchOrdID);
			req.setAttribute("merchOrdVo", merchOrdVo);
			/*=========================查詢完成,準備轉交================================*/
			String url = "????";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		if("update".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/*=========================接受請求參數=====================================*/
			Integer merchOrdID = Integer.valueOf(req.getParameter("merchOrdID"));
			Integer memberID = Integer.valueOf(req.getParameter("memberID"));
			java.sql.Timestamp merchOrdDate = java.sql.Timestamp.valueOf(req.getParameter("merchOrdDate"));
			try {
			Integer merchOrdCount = Integer.valueOf(req.getParameter("merchOrdCount"));
			if(merchOrdCount == null) {
				errorMsgs.put("merchOrdCount", "忘了填數量囉!");
			}
			}catch(NumberFormatException e) {
				errorMsgs.put("merchOrdCount", "請輸入數字格式");
			}
			Byte merchOrdStatus = Byte.valueOf(req.getParameter("merchOrdStatus"));
			
			if(!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("????");
				failureView.forward(req, res);
				return;
			}
			/*=========================開始修改資料=================================*/
			MerchOrdService merchOrdSvc = new MerchOrdService();
			MerchOrdVO merchOrdVo = merchOrdSvc.updateMerchOrd(merchOrdID, memberID, merchOrdDate, merchOrdID, merchOrdStatus);
		}
	}
	

}
