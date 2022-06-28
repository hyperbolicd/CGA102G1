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
			ActdtVO actdtVO = actdtSvc.getOneActdt(act_id);
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
			ActdtVO actdtVO = actdtSvc.getOneActdt(act_id);

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

			Integer tk_type_id = Integer.valueOf(req.getParameter("tk_type_id").trim());

			Double act_discount = null;
			try {
				act_discount = Double.valueOf(req.getParameter("act_discount").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("act_discount", "折扣請填數字");
			}

			Integer act_coupon = Integer.valueOf(req.getParameter("act_coupon").trim());

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/act/updateAct.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			ActdtService actdtSvc = new ActdtService();
			ActdtVO actdtVO = actdtSvc.updateActdt(act_id, tk_type_id, act_discount, act_coupon);

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

			Integer tk_type_id = Integer.valueOf(req.getParameter("tk_type_id").trim());

			Double act_discount = null;
			try {
				act_discount = Double.valueOf(req.getParameter("act_discount").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("act_discount", "折扣請填數字");
			}

			Integer act_coupon = Integer.valueOf(req.getParameter("act_coupon").trim());

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/act/addAct.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			ActdtService actdtSvc = new ActdtService();
			actdtSvc.addActdt(act_id, tk_type_id, act_discount, act_coupon);

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
			actdtSvc.deleteActdt(act_id);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/act/allAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
