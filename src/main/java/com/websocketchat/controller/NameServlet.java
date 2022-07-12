package com.websocketchat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NameServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String userName = req.getParameter("userName"); //從index.jsp獲得使用者輸入的名稱
		
		//使用者名稱寫死
		//String userName = "customer"; //從index.jsp獲得使用者輸入的名稱

		
		//req.setAttribute("userName", userName);
		
		req.setAttribute("userName", userName);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("front_end/chat/chat.jsp");
		dispatcher.forward(req, res);
	}
}
