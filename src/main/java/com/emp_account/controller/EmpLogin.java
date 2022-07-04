package com.emp_account.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp_account.model.EmpAccountService;
import com.emp_account.model.EmpAccountVO;

@WebServlet("/emp/EmpLogin")
public class EmpLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
		
		if("login".equals(request.getParameter("action"))) {
			Map<String, String> errMsg = new LinkedHashMap<String, String>();
			request.setAttribute("errMsg", errMsg);
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String loginId = request.getParameter("loginId");
			String idReg = "^[0-9]*$";
			if(loginId == null || loginId.isEmpty()) {
				errMsg.put("loginId", "請輸入編號");
			} else if(!loginId.matches(idReg)) {
				loginId = "";
				errMsg.put("loginId", "編號僅能為數字");
			}
			
			String loginPassword = request.getParameter("loginPassword");
			if(loginPassword == null || loginPassword.isEmpty()) {
				errMsg.put("loginPassword", "請輸入密碼");
			}
			
			if(!errMsg.isEmpty()) {
				request.setAttribute("loginId", loginId);
				request.setAttribute("loginPassword", loginPassword);
				request.getRequestDispatcher("/back_end/empLogin.jsp").forward(request, response);
				return;
			}
			/***************************2.開始檢查帳號密罵*************************************/
			EmpAccountService empSvc = new EmpAccountService();
			String correctPassword = empSvc.getPassword(Integer.valueOf(loginId));
			
			if(!loginPassword.equals(correctPassword)) {
				errMsg.put("loginId", "編號或密碼錯誤");
				errMsg.put("loginPassword", "編號或密碼錯誤");
				request.getRequestDispatcher("/back_end/empLogin.jsp").forward(request, response);
			}
			
			EmpAccountVO empVO = empSvc.getOneEmp(Integer.valueOf(loginId));
			/***************************3.新增完成,準備轉交(Send the Success view)*************/
			request.getSession().setAttribute("empAccount", empVO);
			String lastPage = (String) request.getSession().getAttribute("lastPage");
			
			if(lastPage == null) { // 好像不會跑到?
				response.sendRedirect(request.getContextPath() + "/back_end/empIndex.jsp");
			} else {
				response.sendRedirect(lastPage);
			}
		}
		
	}

}
