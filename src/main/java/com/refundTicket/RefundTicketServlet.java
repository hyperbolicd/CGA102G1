package com.refundTicket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tk_inf.model.TkInfService;
import com.tk_ord_dt.model.TkOrdDtVO;

@WebServlet("/RefundTicketServlet.do")
public class RefundTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if("getDtByOrd".equals(action)) {
			
			Long tkOrdID = Long.valueOf(req.getParameter("tkOrdID"));
			
			Map map = new HashMap();
			
			// 該張訂單全部的訂單明細
			RefundTicketService rtSvc = new RefundTicketService();
			List<TkOrdDtVO> preparedList = rtSvc.getDtByOrd(tkOrdID);
			// 取回每一張票的票名
			List<String> tkNameList = new ArrayList<String>();
			
			for (TkOrdDtVO dt : preparedList) {
				String tkName = rtSvc.getTicketName(dt.getTkDtID());
				tkNameList.add(tkName);
			}
			
			
			
			Gson gson = new Gson();
			
			res.setContentType("text/json; charset=UTF-8");
//			res.getWriter().write();
			
		}
		
	}

}
