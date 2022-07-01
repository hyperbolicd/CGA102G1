package com.wishing_pond.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wish_reply.model.WishReplyService;
import com.wish_reply.model.WishReplyVO;
import com.wishing_list.model.WishingListService;
import com.wishing_list.model.WishingListVO;

@WebServlet("/wish/WishingVote.do")
public class WishingVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		if("seeOneEvent".equals(action)) {
			// 存放錯誤訊息
			Map<String, String> errMsg = new LinkedHashMap<String, String>();
			request.setAttribute("errMsg", errMsg);
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer wish_no = Integer.valueOf(request.getParameter("wish_no"));
			Integer top_one = Integer.valueOf(request.getParameter("top_one"));
			/***************************2.開始查詢資料*****************************************/
			WishingListService wishListSvc = new WishingListService();
			List<WishingListVO> wishListVOs =  wishListSvc.getOneWishingPond(wish_no);
			if(wishListVOs == null) {
				errMsg.put("notFound", "查無此筆資料");
				request.getRequestDispatcher("/back_end/wish/wishPond.jsp").forward(request, response);
			}
			WishReplyService wishReplySvc = new WishReplyService();
			List<WishReplyVO> wishReplyVOs = wishReplySvc.getOneWishEvent(wish_no);
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			request.setAttribute("wishListVOs", wishListVOs);
			request.setAttribute("wishReplyVOs", wishReplyVOs);
			request.setAttribute("top_one", top_one);
			request.getRequestDispatcher("/back_end/wish/wishDetail.jsp").forward(request, response);
		}
		
		if("voteOneEvent".equals(action)) {
			
		}
	}

}
