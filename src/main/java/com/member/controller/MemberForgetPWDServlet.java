package com.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.member.model.MemberService;

/**
 * Servlet implementation class MemberForgetPWDServlet
 */
@WebServlet("/member/password/forget")
public class MemberForgetPWDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Gson gson = new GsonBuilder().create(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberForgetPWDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//獲取前端傳過來訊息
		String usrEmail = request.getParameter("usrEmail");
		Map<String, String> map= new HashMap<>();
		map.put("stat", "success");
//		System.out.println("123");
		MemberService memberservice = new MemberService();
		memberservice.sendMail(usrEmail);
		try(PrintWriter pw = response.getWriter()){
			pw.print(gson.toJson(map));
		} catch(Exception e){
			e.printStackTrace();
			
		}
	}

	

}