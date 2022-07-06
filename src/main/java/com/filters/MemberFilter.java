package com.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class MemberFilter
 */
//@WebFilter("/front_end/membercentre/*")

public class MemberFilter extends HttpFilter implements Filter {
	
	public void destroy() {
	}
	
    public MemberFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String uri = req.getRequestURI();
		Object memberAccount = req.getSession().getAttribute("memberAccount");
		
		// login 頁面 & css pass
		if(uri.endsWith("Login.jsp") || uri.endsWith(".css") || uri.endsWith(".js")) {
			
			chain.doFilter(request, response);	
			
		// 判斷是否登入過?
		} else if(memberAccount == null) {  
			

			req.getSession().setAttribute("lastPage", req.getRequestURI());
			res.sendRedirect(req.getContextPath() + "/front_end/login/login.jsp");
			
		} else {
			
			chain.doFilter(request, response);

		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
