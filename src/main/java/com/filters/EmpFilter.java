package com.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/back_end/emp/*")
public class EmpFilter extends HttpFilter {
	
	public void destroy() {
	}

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Object empAccount = request.getSession().getAttribute("empAccount");
		
		if(empAccount == null) {
			request.getSession().setAttribute("lastPage", request.getRequestURI());
			response.sendRedirect(request.getContextPath() + "/back_end/empLogin.jsp");
		} else {
			chain.doFilter(request, response);	
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
