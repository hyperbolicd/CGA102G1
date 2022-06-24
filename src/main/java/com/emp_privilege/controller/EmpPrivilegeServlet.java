package com.emp_privilege.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp_privilege.model.EmpPrivilegeService;
import com.emp_privilege.model.EmpPrivilegeVO;

@WebServlet("/emp/EmpPrivilege.do")
public class EmpPrivilegeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if("updatePrivilege".equals(action)) {
			Integer emp_no = Integer.valueOf(request.getParameter("emp_no"));
			response.getWriter().println(emp_no);
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String[] emp_fcs = request.getParameterValues("fc_nos");
			
			boolean fcIsNotEmpty = false;
			List<EmpPrivilegeVO> emp_fc_list = new ArrayList<>();
			
			if(emp_fcs != null) {
				fcIsNotEmpty = true;
				for(String emp_fc: emp_fcs) {
					EmpPrivilegeVO empPrivilegeVO = new EmpPrivilegeVO();
					empPrivilegeVO.setFc_no(Integer.valueOf(emp_fc));
					emp_fc_list.add(empPrivilegeVO);
				}
			}
			/***************************2.開始刪除/新增權限**********************************/
			EmpPrivilegeService empPriSvc = new EmpPrivilegeService();
			List<EmpPrivilegeVO> updateList = new ArrayList();
			for(String emp_fc: emp_fcs) {
				EmpPrivilegeVO empPriVO = new EmpPrivilegeVO();
				empPriVO.setEmp_no(emp_no);
				empPriVO.setFc_no(Integer.valueOf(emp_fc));
				updateList.add(empPriVO);
			}
			empPriSvc.updatePrivilege(updateList);
			
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			request.getSession().setAttribute("lastUpdateEmpNo", emp_no);
			request.getSession().setAttribute("isSucess", "員工編號:" + emp_no + "，權限更新成功!");
			response.sendRedirect(request.getContextPath() + "/back_end/emp/empAcc.jsp");
		}
		
	}

}
