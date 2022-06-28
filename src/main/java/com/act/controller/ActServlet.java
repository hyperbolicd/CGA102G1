package com.act.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.act.model.*;
import com.fd_inf.model.FdInfService;
import com.fd_inf.model.FdInfVO;

@WebServlet("act/act.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)

public class ActServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("act_id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入活動方案編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/act/allAct.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer act_id = null;
			try {
				act_id = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("活動方案編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/act/allAct.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			ActService actSvc = new ActService();
			ActVO actVO = actSvc.getOneAct(act_id);
			if (actVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/act/allAct.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("actVO", actVO); // 資料庫取出的empVO物件,存入req
			String url = "/back_end/act/allAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer act_id = Integer.valueOf(req.getParameter("act_id"));

			/*************************** 2.開始查詢資料 ****************************************/
			ActService actSvc = new ActService();
			ActVO actVO = actSvc.getOneAct(act_id);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("actVO", actVO); // 資料庫取出的empVO物件,存入req
			String url = "/back_end/act/updateAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("getPic".equals(action)) { // 得到照片

			Integer act_id = Integer.valueOf(req.getParameter("act_id").trim());
			ActService actSvc = new ActService();
			ActVO actVO = actSvc.getOneAct(act_id);
			byte[] act_picture = actVO.getAct_picture();
			if (act_picture.length != 0) {

				res.getOutputStream().write(act_picture);
			} else {
				InputStream in = getServletContext().getResourceAsStream("/back_end/act/images/123.png");
				byte[] b = new byte[in.available()];
				in.read(b);
				res.getOutputStream().write(b);
				in.close();
			}
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer act_id = Integer.valueOf(req.getParameter("act_id").trim());

			byte[] act_picture = req.getPart("act_picture").getInputStream().readAllBytes();
			if (act_picture.length == 0) {
				ActService actSvc = new ActService();
				ActVO actVO = actSvc.getOneAct(act_id);
				act_picture = actVO.getAct_picture();
			}

			String act_title = req.getParameter("act_title");
			String act_titleReg = "^{2,20}$";
			if (act_title == null || act_title.trim().length() == 0) {
				errorMsgs.add("活動方案標題: 請勿空白");
			} else if (!act_title.trim().matches(act_titleReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("活動方案標題: 長度必需在2到20之間");
			}

			String act_subtitle = req.getParameter("act_subtitle");
			String act_subtitleReg = "^{2,40}$";
			if (act_subtitle == null || act_subtitle.trim().length() == 0) {
				errorMsgs.add("活動方案標題: 請勿空白");
			} else if (!act_title.trim().matches(act_subtitleReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("活動方案標題: 長度必需在2到40之間");
			}

			String act_content = req.getParameter("act_content").trim();

			java.sql.Timestamp act_time_start = null;
			try {
				act_time_start = java.sql.Timestamp.valueOf(req.getParameter("act_time_start").trim());
			} catch (IllegalArgumentException e) {
				act_time_start = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			java.sql.Timestamp act_time_end = null;
			try {
				act_time_end = java.sql.Timestamp.valueOf(req.getParameter("act_time_end").trim());
			} catch (IllegalArgumentException e) {
				act_time_end = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			java.lang.Byte act_status = java.lang.Byte.valueOf(req.getParameter("act_status"));

			ActVO actVO = new ActVO();
			actVO.setAct_picture(act_picture);
			actVO.setAct_title(act_title);
			actVO.setAct_subtitle(act_subtitle);
			actVO.setAct_content(act_content);
			actVO.setAct_time_start(act_time_start);
			actVO.setAct_time_end(act_time_end);
			actVO.setAct_status(act_status);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("actVO", actVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/act/updateAct.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			ActService actSvc = new ActService();
			actVO = actSvc.updateAct(act_id, act_picture, act_title, act_subtitle, act_content, act_time_start,
					act_time_end, act_status);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("actVO", actVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back_end/act/allAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			// Integer act_id = Integer.valueOf(req.getParameter("act_id").trim());

			Part part = req.getPart("act_picture");
			InputStream in = part.getInputStream();
			byte[] act_picture = new byte[in.available()];
			in.read(act_picture);
			in.close();

			String act_title = req.getParameter("act_title");
			String act_titleReg = "^{2,20}$";
			if (act_title == null || act_title.trim().length() == 0) {
				errorMsgs.add("活動方案標題: 請勿空白");
			} else if (!act_title.trim().matches(act_titleReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("活動方案標題: 長度必需在2到20之間");
			}

			String act_subtitle = req.getParameter("act_subtitle");
			String act_subtitleReg = "^{2,40}$";
			if (act_subtitle == null || act_subtitle.trim().length() == 0) {
				errorMsgs.add("活動方案標題: 請勿空白");
			} else if (!act_title.trim().matches(act_subtitleReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("活動方案標題: 長度必需在2到40之間");
			}

			String act_content = req.getParameter("act_content").trim();

			java.sql.Timestamp act_time_start = null;
			try {
				act_time_start = java.sql.Timestamp.valueOf(req.getParameter("act_time_start").trim());
			} catch (IllegalArgumentException e) {
				act_time_start = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			java.sql.Timestamp act_time_end = null;
			try {
				act_time_end = java.sql.Timestamp.valueOf(req.getParameter("act_time_end").trim());
			} catch (IllegalArgumentException e) {
				act_time_end = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			java.lang.Byte act_status = java.lang.Byte.valueOf(req.getParameter("act_status"));

			ActVO actVO = new ActVO();
			actVO.setAct_picture(act_picture);
			actVO.setAct_title(act_title);
			actVO.setAct_subtitle(act_subtitle);
			actVO.setAct_content(act_content);
			actVO.setAct_time_start(act_time_start);
			actVO.setAct_time_end(act_time_end);
			actVO.setAct_status(act_status);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("actVO", actVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/act/addAct.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			ActService actSvc = new ActService();
			actVO = actSvc.addAct(act_picture, act_title, act_subtitle, act_content, act_time_start, act_time_end,
					act_status);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/act/allAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer act_id = Integer.valueOf(req.getParameter("act_id"));

			/*************************** 2.開始刪除資料 ***************************************/
			ActService actSvc = new ActService();
			actSvc.deleteAct(act_id);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/act/allAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}

		if ("updateStatus".equals(action)) { // 來自listAllEmp.jsp 或 /dept/listEmps_ByDeptno.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			PrintWriter out = res.getWriter();

			/*************************** 1.接收請求參數 ***************************************/
			Integer act_id = Integer.valueOf(req.getParameter("act_id"));

			/*************************** 2.開始修改資料 ***************************************/
			ActService actSvc = new ActService();
			actSvc.actStatus(act_id);
			ActVO actVO = actSvc.getOneAct(act_id);

			// 將最新的狀態丟回去
			java.lang.Byte newStatus = actVO.getAct_status();
//			HashMap<String, Byte> map = new HashMap<String, Byte>();
//			JSONObject jsonobj = new JSONObject();
//			try {
//				jsonobj.put("newStatus", newStatus);
//				out.print(jsonobj.toString());
//				return;
//			}catch(JSONException e) {
//				e.printStackTrace();
//			}finally {
//				out.flush();
//				out.close();
//			}

			/*************************** 3.修改完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/act/allAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}

	}
}
