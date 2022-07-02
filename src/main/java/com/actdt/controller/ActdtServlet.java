package com.actdt.controller;

import java.io.*;

import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.actdt.model.*;


public class ActdtServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//				String str = req.getParameter("act_id");
//				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.put("act_id","請輸入活動方案編號");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/back_end/act/allAct.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}

			Integer act_id = null;
			try {
				act_id = Integer.valueOf(act_id);
			} catch (Exception e) {
				errorMsgs.put("act_id", "活動方案編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/act/allAct.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			ActdtService actdtSvc = new ActdtService();
			ActdtVO actdtVO = actdtSvc.findByPrimaryKey(act_id);
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

			/*************************** 2.開始查詢資料 ****************************************/
			ActdtService actdtSvc = new ActdtService();
			ActdtVO actdtVO = actdtSvc.findByPrimaryKey(act_id);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("actdtVO", actdtVO); // 資料庫取出的empVO物件,存入req
			String url = "/back_end/act/updateAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

//			Map<String, String> errorMsgs1 = new LinkedHashMap<String, String>();
//			req.setAttribute("errorMsgs", errorMsgs1);
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer act_id = Integer.valueOf(req.getParameter("act_id").trim());
			
			String act_title = req.getParameter("act_title");
			String act_titleReg = "^{2,20}$";
			if (act_title == null || act_title.trim().length() == 0) {
				errorMsgs.add("活動方案標題: 請勿空白");
			} else if (!act_title.trim().matches(act_titleReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("活動方案標題: 長度必需在2到20之間");
			}

			Integer tk_type_id = Integer.valueOf(req.getParameter("tk_type_id").trim());

			Double act_discount = null;
			try {
				act_discount = Double.valueOf(req.getParameter("act_discount").trim());
			} catch (NumberFormatException e) {
				((Map<String, String>) errorMsgs).put("act_discount", "折扣請填數字");
			}

			Integer act_coupon = Integer.valueOf(req.getParameter("act_coupon").trim());
			
			java.lang.Byte act_status = java.lang.Byte.valueOf(req.getParameter("act_status"));

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/act/updateAct.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			ActdtService actdtSvc = new ActdtService();
			ActdtVO actdtVO = actdtSvc.update(act_id, act_title, tk_type_id, act_discount, act_coupon, act_status);

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
			
			String act_title = req.getParameter("act_title");

			Integer tk_type_id = Integer.valueOf(req.getParameter("tk_type_id").trim());

			Double act_discount = null;
			try {
				act_discount = Double.valueOf(req.getParameter("act_discount").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("act_discount", "折扣請填數字");
			}

			Integer act_coupon = Integer.valueOf(req.getParameter("act_coupon").trim());
			
			java.lang.Byte act_status = java.lang.Byte.valueOf(req.getParameter("act_status"));

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/act/addAct.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			ActdtService actdtSvc = new ActdtService();
			actdtSvc.insert(act_id, act_title, tk_type_id, act_discount, act_coupon, act_status);

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

			/*************************** 2.開始刪除資料 ***************************************/
			ActdtService actdtSvc = new ActdtService();
			actdtSvc.delete(act_id);

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
