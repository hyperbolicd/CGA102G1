package com.ann.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.ann.model.*;
import com.faq.model.FaqService;
import com.faq.model.FaqVO;
import com.fd_inf.model.FdInfService;
import com.fd_inf.model.FdInfVO;

@WebServlet("/ann/ann.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)

public class AnnServlet extends HttpServlet {

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
			String str = req.getParameter("ann_no");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("ann_no", "請輸入公告編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/ann/allAnn.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer ann_no = null;
			try {
				ann_no = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("ann_no", "公告編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/ann/allAnn.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			AnnService annSvc = new AnnService();
			AnnVO annVO = annSvc.getOneAnn(ann_no);
			if (annVO == null) {
				errorMsgs.put("ann_no", "查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/ann/allAnn.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("annVO", annVO); // 資料庫取出的tkInfVO物件,存入req
			String url = "/back_end/ann/allAnn.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 allTkInf.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自allTkInf.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer ann_no = Integer.valueOf(req.getParameter("ann_no"));

			/*************************** 2.開始查詢資料 ****************************************/
			AnnService annSvc = new AnnService();
			AnnVO annVO = annSvc.getOneAnn(ann_no);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			String param = "?ann_no=" + annVO.getAnn_no() + "&ann_date=" + annVO.getAnn_date() + "&ann_title="
					+ annVO.getAnn_title() + "&editor1=" + annVO.getAnn_content() + "&ann_picture="
					+ annVO.getAnn_picture();
			String url = "/back_end/ann/updateAnn.jsp" + param;
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 updateTkInf.jsp
			successView.forward(req, res);
		}
		
		if ("getPic".equals(action)) {

//			Integer ann_no = Integer.valueOf(req.getParameter("ann_no"));
			Integer ann_no = Integer.valueOf(req.getParameter("ann_no").trim());
			AnnService annSvc = new AnnService();
			AnnVO annVO = annSvc.getOneAnn(ann_no);
			byte[] ann_picture = annVO.getAnn_picture();
			if (ann_picture.length != 0) {
				
				res.getOutputStream().write(ann_picture);
			}else {
				InputStream in = getServletContext().getResourceAsStream("/back_end/ann/imges/123.png");
			    byte[] b = new byte[in.available()];
			    in.read(b);
			    res.getOutputStream().write(b);
			    in.close();
			}
		}
		

		if ("update".equals(action)) { // 來自updateTkInf.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer ann_no = Integer.valueOf(req.getParameter("ann_no").trim());

			java.sql.Date ann_date = null;
			try {
				ann_date = java.sql.Date.valueOf(req.getParameter("ann_date").trim());
			} catch (IllegalArgumentException e) {
				ann_date = new java.sql.Date(System.currentTimeMillis());
			}

			String ann_title = req.getParameter("ann_title");
			String ann_titleReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,50}$";
			if (ann_title == null || ann_title.trim().length() == 0) {
				errorMsgs.put("ann_title", "公告標題: 請勿空白");
			} else if (!ann_title.trim().matches(ann_titleReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("ann_title", "公告標題: 只能是中、英文字母、數字和_ , 且長度必需在2到50之間");
			}

			String ann_content = req.getParameter("editor1").trim();

			Part part = req.getPart("ann_picture");
			InputStream in = part.getInputStream();
			byte[] ann_picture = new byte[in.available()];
			in.read(ann_picture);
			in.close();
			
			AnnVO annVO = new AnnVO();
			annVO.setAnn_no(ann_no);
			annVO.setAnn_date(ann_date);
			annVO.setAnn_title(ann_title);
			annVO.setAnn_content(ann_content);
			annVO.setAnn_picture(ann_picture);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/ann/updateAnn.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}


			/*************************** 2.開始修改資料 *****************************************/
			AnnService annSvc = new AnnService();
			annVO = annSvc.updateAnn(ann_no, ann_date, ann_title, ann_content, ann_picture);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("annVO", annVO); // 資料庫update成功後,正確的的tkTypeVO物件,存入req
			String url = "/back_end/ann/allAnn.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交allTkInf.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addTkInf.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			//Integer ann_no = Integer.valueOf(req.getParameter("ann_no").trim());

			java.sql.Date ann_date = null;
			try {
				ann_date = java.sql.Date.valueOf(req.getParameter("ann_date").trim());
			} catch (IllegalArgumentException e) {
				ann_date = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.put("請輸入日期!!", "2022-03-14");
			}

			String ann_title = req.getParameter("ann_title");
			String ann_titleReg = "{2,50}$";
			if (ann_title == null || ann_title.trim().length() == 0) {
				errorMsgs.put("ann_title", "公告標題: 請勿空白");
			} else if (!ann_title.trim().matches(ann_titleReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("ann_title", "公告標題: 長度必需在2到50之間");
			}

			String ann_content = req.getParameter("editor1").trim();

			Part part = req.getPart("ann_picture");
			InputStream in = part.getInputStream();
			byte[] ann_picture = new byte[in.available()];
			in.read(ann_picture);
			in.close();

			AnnVO annVO = new AnnVO();
			//annVO.setAnn_no(ann_no);
			annVO.setAnn_date(ann_date);
			annVO.setAnn_title(ann_title);
			annVO.setAnn_content(ann_content);
			annVO.setAnn_picture(ann_picture);
			
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/ann/addAnn.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			AnnService annSvc = new AnnService();
			annSvc.addAnn(ann_date, ann_title, ann_content, ann_picture);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/ann/allAnn.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交allTkInf.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自allTkInf.jsp

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer ann_no = Integer.valueOf(req.getParameter("ann_no"));

			/*************************** 2.開始刪除資料 ***************************************/
			AnnService annSvc = new AnnService();
			annSvc.deleteAnn(ann_no);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/ann/allAnn.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
