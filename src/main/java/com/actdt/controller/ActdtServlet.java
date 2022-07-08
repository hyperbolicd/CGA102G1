package com.actdt.controller;

import java.io.*;
import java.sql.Date;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;


import com.actdt.model.*;


public class ActdtServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@SuppressWarnings("null")
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

			Integer act_id = null;
			try {
				act_id = Integer.valueOf(act_id);
			} catch (Exception e) {
				errorMsgs.put("act_id", "活動方案編號格式不正確");
			}
			
			Integer tkTypeID = null;
			try {
				tkTypeID = Integer.valueOf(tkTypeID);
			} catch (Exception e) {
				errorMsgs.put("act_id", "票種編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/act/allAct.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			ActdtService actdtSvc = new ActdtService();
			ActdtVO actdtVO = actdtSvc.findByPrimaryKey(act_id, tkTypeID);
			if (actdtVO == null) {
				errorMsgs.put("act_id", "查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/act/allAct.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("actdtVO", actdtVO); // 資料庫取出的empVO物件,存入req
			String url = "/back_end/act/allAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer act_id = Integer.valueOf(req.getParameter("act_id"));
			Integer tkTypeID = Integer.valueOf(req.getParameter("tkTypeID"));

			/*************************** 2.開始查詢資料 ****************************************/
			ActdtService actdtSvc = new ActdtService();
			ActdtVO actdtVO = actdtSvc.findByPrimaryKey(act_id, tkTypeID);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("actdtVO", actdtVO); // 資料庫取出的empVO物件,存入req
			String url = "/back_end/act/updateAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer act_id = Integer.valueOf(req.getParameter("act_id").trim());
			
			java.sql.Date act_date_start = null;
			try {
				act_date_start = java.sql.Date.valueOf(req.getParameter("act_date_start").trim());
			} catch (IllegalArgumentException e) {
				act_date_start = new java.sql.Date(System.currentTimeMillis());
			}
			
			String act_title = req.getParameter("act_title");
			if (act_title == null || act_title.trim().length() == 0) {
				errorMsgs.put("act_title","活動方案標題: 請勿空白");
			}
			
			String act_subtitle = req.getParameter("act_subtitle");
			if (act_subtitle == null || act_subtitle.trim().length() == 0) {
				errorMsgs.put("act_subtitle","活動方案副標題: 請勿空白");
			}

			Integer tkTypeID = Integer.valueOf(req.getParameter("tk_type_id").trim());

			Double act_discount = null;
			try {
				act_discount = Double.valueOf(req.getParameter("act_discount").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("act_discount", "折扣請填數字");
			}

			Integer act_coupon = Integer.valueOf(req.getParameter("act_coupon").trim());
			
			java.lang.Byte act_status = java.lang.Byte.valueOf(req.getParameter("act_status"));
			
			String act_content = req.getParameter("act_content").trim();
			
			Part part = req.getPart("act_picture");
			byte[] act_picture = null;
			InputStream in = null;
			if(part.getSize() == 0) {
				ActdtService actSvc = new ActdtService();
				act_picture = actSvc.getOneActdt(act_id,tkTypeID).getAct_picture();
			} else {
				in = part.getInputStream();
				act_picture = new byte[in.available()];
				in.read(act_picture);
				in.close();
			}
			
			ActdtVO actdtVO = new ActdtVO();
			actdtVO.setAct_id(act_id);
			actdtVO.setAct_date_start(act_date_start);
			actdtVO.setAct_title(act_title);
			actdtVO.setAct_subtitle(act_subtitle);
			actdtVO.setTkTypeID(tkTypeID);
			actdtVO.setAct_discount(act_discount);
			actdtVO.setAct_coupon(act_coupon);
			actdtVO.setAct_status(act_status);
			actdtVO.setAct_content(act_content);
			actdtVO.setAct_picture(act_picture);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/act/updateAct.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			ActdtService actdtSvc = new ActdtService();
			actdtVO = actdtSvc.update(act_id,act_date_start, act_title, act_subtitle, tkTypeID, act_discount, act_coupon, act_status, act_content, act_picture);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("actdtVO", actdtVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back_end/act/allAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer act_id = Integer.valueOf(req.getParameter("act_id").trim());
			
			java.sql.Date act_date_start = null;
			try {
				act_date_start = java.sql.Date.valueOf(req.getParameter("act_date_start").trim());
			} catch (IllegalArgumentException e) {
				act_date_start = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.put("act_date_start","請輸入日期!");
			}
			
			String act_title = req.getParameter("act_title");
			
			String act_subtitle = req.getParameter("act_subtitle");
			if (act_subtitle == null || act_subtitle.trim().length() == 0) {
				errorMsgs.put("act_subtitle","活動方案副標題: 請勿空白");
			}

			Integer TkTypeID = Integer.valueOf(req.getParameter("tk_type_id").trim());

			Double act_discount = null;
			try {
				act_discount = Double.valueOf(req.getParameter("act_discount").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("act_discount", "折扣請填數字");
			}

			Integer act_coupon = Integer.valueOf(req.getParameter("act_coupon").trim());
			
			java.lang.Byte act_status = java.lang.Byte.valueOf(req.getParameter("act_status"));
			
			String act_content = req.getParameter("act_content").trim();
			
			Part part = req.getPart("act_picture");
			InputStream in = part.getInputStream();
			byte[] act_picture = new byte[in.available()];
			in.read(act_picture);
			in.close();
			
//			璟謙講解
//			List<e> list = new LinkedList<E>();
//			for(Integer id : req.getParameter("name")) {
//				xxxVO xxx = new XXX();
//				xxx.set()
//				
//				list.add(xxx);
//			}

			
			
			ActdtVO actdtVO = new ActdtVO();
			actdtVO.setAct_id(act_id);
			actdtVO.setAct_date_start(act_date_start);
			actdtVO.setAct_title(act_title);
			actdtVO.setAct_subtitle(act_subtitle);
			actdtVO.setTkTypeID(TkTypeID);
			actdtVO.setAct_discount(act_discount);
			actdtVO.setAct_coupon(act_coupon);
			actdtVO.setAct_status(act_status);
			actdtVO.setAct_content(act_content);
			actdtVO.setAct_picture(act_picture);
			
			

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/act/addAct.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			ActdtService actdtSvc = new ActdtService();
			actdtSvc.insert(act_id,act_date_start, act_title, act_subtitle, TkTypeID, act_discount, act_coupon, act_status, act_content, act_picture);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/act/allAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer act_id = Integer.valueOf(req.getParameter("act_id"));
			Integer tkTypeID = Integer.valueOf(req.getParameter("tkTypeID"));

			/*************************** 2.開始刪除資料 ***************************************/
			ActdtService actdtSvc = new ActdtService();
			actdtSvc.delete(act_id, tkTypeID);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/act/allAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
		
		
		
//		if ("getOne_For_Status".equals(action)) { // 來自select_page.jsp的請求
//			String str = req.getParameter("act_status");
//			System.out.println("====" + str);
//			System.out.println("status: "+ action);
//
//			  List<String> errorMsgs = new LinkedList<String>();
//			  req.setAttribute("errorMsgs", errorMsgs);
//			  Integer act_status = Integer.parseInt(req.getParameter("act_status")); // 資料庫取出的newspostVO物件,存入req
//			  System.out.println("newsStatus:"+act_status);
//			  
//			  ActdtService a = new ActdtService();
//			  List<ActdtVO> actdtVO = a.getAct_status(act_status);
//			  System.out.println("actdtVO:"+actdtVO);
//			  
//			  
//			  req.getSession().setAttribute("actdtVO", actdtVO);
//			  req.getSession().setAttribute("newsStatus", act_status);
//			  String url = "/back_end/newspost/listStatusNewsPost.jsp";
//			  RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//			  successView.forward(req, res);
//			 }
//		
		
		
	}
}
