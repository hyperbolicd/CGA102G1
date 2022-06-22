package com.emp_account.controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmpLogin")
public class EmpLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		if("login".equals(request.getParameter("action"))) {
			Map<String, String> errMsg = new LinkedHashMap();
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
				return;
			}
			/***************************2.開始檢查帳號密罵*************************************/
			
			
			/***************************3.新增完成,準備轉交(Send the Success view)*************/
		}
		
	}

}
