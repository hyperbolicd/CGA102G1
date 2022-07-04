package com.filters;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp_account.model.EmpAccountVO;
import com.emp_function.model.EmpFunctionService;
import com.emp_privilege.model.EmpPrivilegeService;
import com.emp_privilege.model.EmpPrivilegeVO;

@WebFilter("/back_end/*")
public class EmpPrivilegeFilter extends HttpFilter {
	
	private static final long serialVersionUID = 1L;

	public void destroy() {
	}

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String uri = request.getRequestURI(); // 自己
		EmpAccountVO empAccount = (EmpAccountVO)request.getSession().getAttribute("empAccount");
		
		// login 頁面 & css & js pass
		if(uri.endsWith("empLogin.jsp") || uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith("logo2noline.jpg")) {
			chain.doFilter(request, response);	
			return;
		} 
		
		// 存放可前往的頁面並放入首頁
		Set<String> priUri = new HashSet<String>();	
		priUri.add(request.getContextPath() + "/back_end/empIndex.jsp");
		
		if(empAccount != null) { // 避免未登入時空指標
			// 查詢權限號碼
			List<EmpPrivilegeVO> priList = new EmpPrivilegeService().getOneEmpPrivileges(empAccount.getEmp_no());
			EmpFunctionService empFcSvc = new EmpFunctionService();
			// 將權限號碼對應的網址放入 HashSet
			for(EmpPrivilegeVO pri: priList) {
				String accessUri = request.getContextPath() + empFcSvc.getOneFunc(pri.getFc_no()).getFc_description();
				priUri.add(accessUri);
			}
		} else {
			System.out.println("尚未登入");
		}
		
		// 判斷可前往的頁面是否包含自己
		if(priUri.contains(uri)) { // 有包含，放行
			chain.doFilter(request, response);	
		} else { // 未包含，導回首頁
			response.sendRedirect(request.getContextPath() + "/back_end/empIndex.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
