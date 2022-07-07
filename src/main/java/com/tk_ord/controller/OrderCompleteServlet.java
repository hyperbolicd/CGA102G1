package com.tk_ord.controller;

import java.io.IOException;
import java.lang.reflect.Array;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.actdt.model.ActdtService;
import com.actdt.model.ActdtVO;
import com.fd_inf.model.FdInfService;
import com.fd_inf.model.FdInfVO;
import com.fd_ord_dt.model.FdOrdDtVO;
import com.google.gson.Gson;
import com.hall.model.HallService;
import com.hall.model.HallVO;
import com.member.model.MemberService;
import com.member.model.MemberVO;
import com.movie.model.MovieService;
import com.movie.model.MovieVO;
import com.showing.model.*;
import com.tk_inf.model.TkInfService;
import com.tk_inf.model.TkInfVO;
import com.tk_ord.model.FDorder;
import com.tk_ord.model.Order;
import com.tk_ord.model.TKorder;
import com.tk_ord.model.TkOrdService;
import com.tk_ord.model.TkOrdVO;
import com.tk_ord_dt.model.TkOrdDtVO;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/OrderCompleteServlet")


public class OrderCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		res.setContentType("application/json; charset=UTF-8");
		HttpSession session = req.getSession();

		if ("completeOrder".equals(action)) { // 來自allFdInf.jsp的請求

			Gson gson = new Gson();
			System.out.print(req.getParameter("order"));
			Order order = gson.fromJson(req.getParameter("order"), Order.class);
			
			/*************************** 1.接收請求參數 ****************************************/
			
			Integer MemberID = order.getMemberID();
			Integer SH_ID = order.getSH_ID();
			
	
			/*************************** 2.開始新增資料 ***************************************/
			TkOrdVO tkOrdVO = new TkOrdVO();
			tkOrdVO.setMemberID(MemberID);
			tkOrdVO.setShID(SH_ID);

			List<TkOrdDtVO> tkOrdDtList = new ArrayList<TkOrdDtVO>();
			 // 員工POJO1
			TKorder[] tKorder = order.getTKorder();
			String[] seat = order.getSeatindex();
			for (int i = 0 ; i<tKorder.length; i++ ) {			
				TkOrdDtVO tkOrdDt = new TkOrdDtVO();
				tkOrdDt.setTkTypeID(tKorder[i].getId());
				tkOrdDt.setActID(tKorder[i].getActId());
				tkOrdDt.setState(Byte.valueOf("0"));
				tkOrdDt.setSeat(seat[i]);
				tkOrdDt.setSellPrice(tKorder[i].getSalePrice());
				tkOrdDtList.add(tkOrdDt);
			}
				
			List<FdOrdDtVO> fdOrdDtList = new ArrayList<FdOrdDtVO>(); 
			
			for(FDorder fdorder : order.getFDorder()) {
				
				FdOrdDtVO fdOrdDt = new FdOrdDtVO(); 
				
				fdOrdDt.setFdID(fdorder.getId());
				fdOrdDt.setFdCount(fdorder.getCount());
				fdOrdDt.setFdState(Byte.valueOf("0"));
				fdOrdDt.setSellPrice(fdorder.getUnitPrice() * fdorder.getCount());
				
				fdOrdDtList.add(fdOrdDt);
				
			}
			
//			增加許願票數
			MemberService memberService = new MemberService();
			MemberVO memberVO = memberService.getOneMem(MemberID);
			Integer wishTicket = memberVO.getWish_Ticket();
			wishTicket = wishTicket + tKorder.length;
			TkOrdService tkOrdSvc = new TkOrdService();
			
			tkOrdSvc.insertWithTkOrdDtsAndFdOrdDts(tkOrdVO, tkOrdDtList, fdOrdDtList);
			memberService.updateWishTicket(MemberID, wishTicket);
		}
		
	}	

}





