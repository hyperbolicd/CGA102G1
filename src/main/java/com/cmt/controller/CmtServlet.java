package com.cmt.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmt.model.*;

public class CmtServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page_cmt.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("CM_ID");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入評論編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back/select_page_cmt.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer CM_ID = null;
				try {
					CM_ID = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("評論編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back/select_page_cmt.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				CmtService cmtSvc = new CmtService();
				CmtVO cmtVO = cmtSvc.getOneCmt(CM_ID);
				if (cmtVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back/select_page_cmt.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("cmtVO", cmtVO); // 資料庫取出的cmtVO物件,存入req
				String url = "/back/listOneCmt.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer CM_ID = Integer.valueOf(req.getParameter("CM_ID"));
				
				/***************************2.開始查詢資料****************************************/
				CmtService cmtSvc = new CmtService();
				CmtVO cmtVO = cmtSvc.getOneCmt(CM_ID);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("cmtVO", cmtVO);         // 資料庫取出的cmtVO物件,存入req
				String url = "/emp/update_cmt_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/

				Integer CM_ID = Integer.valueOf(req.getParameter("CM_ID"));
				try {
					CM_ID = Integer.valueOf(req.getParameter("CM_ID").trim());
				} catch (NumberFormatException e) {
					CM_ID = 0;
					errorMsgs.add("評論編號請填數字.");
				}
				
				Integer MEMBER_ID = Integer.valueOf(req.getParameter("MEMBER_ID"));
				try {
					MEMBER_ID = Integer.valueOf(req.getParameter("MEMBER_ID").trim());
				} catch (NumberFormatException e) {
					MEMBER_ID = 0;
					errorMsgs.add("會員編號請填數字.");
				}
				
				Integer MV_ID = Integer.valueOf(req.getParameter("MV_ID"));
				try {
					MV_ID = Integer.valueOf(req.getParameter("MV_ID").trim());
				} catch (NumberFormatException e) {
					MV_ID = 0;
					errorMsgs.add("電影編號請填數字.");
				}
				
				String CM_TEXT = req.getParameter("CM_TEXT");
				
				Integer CM_LIKE = Integer.valueOf(req.getParameter("CM_LIKE"));
				try {
					CM_LIKE = Integer.valueOf(req.getParameter("CM_LIKE").trim());
				} catch (NumberFormatException e) {
					CM_LIKE = 0;
					errorMsgs.add("按讚數請填數字.");
				}
				
				Integer CM_STAR = Integer.valueOf(req.getParameter("CM_STAR"));
				try {
					CM_STAR = Integer.valueOf(req.getParameter("CM_STAR").trim());
				} catch (NumberFormatException e) {
					CM_STAR = 0;
					errorMsgs.add("星星數請填數字.");
				}
				
				Integer CM_STATE = Integer.valueOf(req.getParameter("CM_STATE"));
				try {
					CM_STATE = Integer.valueOf(req.getParameter("CM_STATE").trim());
				} catch (NumberFormatException e) {
					CM_STATE = 0;
					errorMsgs.add("狀態請填數字.");
				}	
				
				Timestamp CM_DATE = null;
				try {
					CM_DATE = Timestamp.valueOf(req.getParameter("CM_DATE").trim());
				} catch (IllegalArgumentException e) {
					CM_DATE=new Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				

				CmtVO cmtVO = new CmtVO();
				cmtVO.setCM_ID(CM_ID);
				cmtVO.setMEMBER_ID(MEMBER_ID);
				cmtVO.setMV_ID(MV_ID);
				cmtVO.setCM_TEXT(CM_TEXT);
				cmtVO.setCM_LIKE(CM_LIKE);
				cmtVO.setCM_STAR(CM_STAR);
				cmtVO.setCM_STATE(CM_STATE);
				cmtVO.setCM_DATE(CM_DATE);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("cmtVO", cmtVO); // 含有輸入格式錯誤的cmtVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/emp/update_cmt_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				CmtService cmtSvc = new CmtService();
				cmtVO = cmtSvc.updateCmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE,CM_STAR, CM_STATE, CM_DATE);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("cmtVO", cmtVO); // 資料庫update成功後,正確的的cmtVO物件,存入req
				String url = "/back/listOneCmt.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
		}

        if ("insert".equals(action)) { // 來自addCmt.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			Integer MEMBER_ID = Integer.valueOf(req.getParameter("MEMBER_ID"));
			try {
				MEMBER_ID = Integer.valueOf(req.getParameter("MEMBER_ID").trim());
			} catch (NumberFormatException e) {
				MEMBER_ID = 0;
				errorMsgs.add("會員編號請填數字.");
			}
			
			Integer MV_ID = Integer.valueOf(req.getParameter("MV_ID"));
			try {
				MV_ID = Integer.valueOf(req.getParameter("MV_ID").trim());
			} catch (NumberFormatException e) {
				MV_ID = 0;
				errorMsgs.add("電影編號請填數字.");
			}
			
			String CM_TEXT = req.getParameter("CM_TEXT");
			
			Integer CM_LIKE = Integer.valueOf(req.getParameter("CM_LIKE"));
			try {
				CM_LIKE = Integer.valueOf(req.getParameter("CM_LIKE").trim());
			} catch (NumberFormatException e) {
				CM_LIKE = 0;
				errorMsgs.add("按讚數請填數字.");
			}
			
			Integer CM_STAR = Integer.valueOf(req.getParameter("CM_STAR"));
			try {
				CM_STAR = Integer.valueOf(req.getParameter("CM_STAR").trim());
			} catch (NumberFormatException e) {
				CM_STAR = 0;
				errorMsgs.add("星星數請填數字.");
			}
			
			Integer CM_STATE = Integer.valueOf(req.getParameter("CM_STATE"));
			try {
				CM_STATE = Integer.valueOf(req.getParameter("CM_STATE").trim());
			} catch (NumberFormatException e) {
				CM_STATE = 0;
				errorMsgs.add("狀態請填數字.");
			}	
			
			Timestamp CM_DATE = null;
			try {
				CM_DATE = Timestamp.valueOf(req.getParameter("CM_DATE").trim());
			} catch (IllegalArgumentException e) {
				CM_DATE=new Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}
			

			CmtVO cmtVO = new CmtVO();
			cmtVO.setMEMBER_ID(MEMBER_ID);
			cmtVO.setMV_ID(MV_ID);
			cmtVO.setCM_TEXT(CM_TEXT);
			cmtVO.setCM_LIKE(CM_LIKE);
			cmtVO.setCM_STAR(CM_STAR);
			cmtVO.setCM_STATE(CM_STATE);
			cmtVO.setCM_DATE(CM_DATE);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("cmtVO", cmtVO); // 含有輸入格式錯誤的cmtVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back/addCmt.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				CmtService cmtSvc = new CmtService();
				cmtVO = cmtSvc.addCmt(MEMBER_ID, MV_ID, CM_TEXT, CM_LIKE, CM_STAR, CM_STATE, CM_DATE);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back/listAllCmt.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
		}
		
		
		if ("delete".equals(action)) { // 來自listAllCmt.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer CM_ID = Integer.valueOf(req.getParameter("CM_ID"));
				
				/***************************2.開始刪除資料***************************************/
				CmtService cmtSvc = new CmtService();
				cmtSvc.deleteCmt(CM_ID);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back/listAllCmt.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
}