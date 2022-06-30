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

import com.changeSeat.ShowSeatService;
import com.changeSeat.ShowSeatVO;
import com.google.gson.Gson;
import com.tk_inf.model.TkInfService;
import com.tk_ord.model.TkOrdService;
import com.tk_ord.model.TkOrdVO;
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
			List<TkOrdDtVO> dtVOList = rtSvc.getDtByOrd(tkOrdID);
			List<String> tkNameList = new ArrayList<String>();
			List<String> actTitleList = new ArrayList<String>();
			for (TkOrdDtVO dt : dtVOList) {
				
				// 取回每一張票的票名
				String tkName = rtSvc.getTicketName(dt.getTkTypeID());
				tkNameList.add(tkName);
				// 獲取每一張票的活動方案名
				String actTitle = rtSvc.getActTitle(dt.getActID());
				actTitleList.add(actTitle);
				
			}
			
			// 獲取這張訂單內的場次座位字串
			TkOrdService tkOrdSvc = new TkOrdService();
			TkOrdVO ordVO = tkOrdSvc.getOneTkInf(tkOrdID);
			
			ShowSeatService ssSvc = new ShowSeatService();
			ShowSeatVO showSeatVO =ssSvc.getShowByTime(ordVO.getShID());
			String SH_SEAT_STATE = showSeatVO.getSH_SEAT_STATE();
			
			map.put("SH_SEAT_STATE", SH_SEAT_STATE);
			map.put("dtVOList", dtVOList);
			map.put("tkNameList", tkNameList);
			map.put("actTitleList", actTitleList);
			/* ******************************************************** */
			
			Gson gson = new Gson();
			
			res.setContentType("text/json; charset=UTF-8");
			res.getWriter().write(gson.toJson(map));
			
		}
		if("updateOneDt".equals(action)) {
			Long tkDtID = Long.valueOf(req.getParameter("tkDtID"));
			Integer seatIndex = Integer.valueOf(req.getParameter("seatIndex"));
			Long tkOrdID = Long.valueOf(req.getParameter("tkOrdID"));
			String seatStr = req.getParameter("seatStr");
			// 獲取這張訂單內的場次座位字串
			TkOrdService tkOrdSvc = new TkOrdService();
			TkOrdVO ordVO = tkOrdSvc.getOneTkInf(tkOrdID);
						
			ShowSeatService ssSvc = new ShowSeatService();
			
			System.out.println(tkDtID);
			System.out.println(seatIndex);
			System.out.println(tkOrdID);
			System.out.println(seatStr);
			
			// Update場次座位字串
			ssSvc.updateShowSeat(seatStr, ordVO.getShID());
			// Update訂單明細狀態
			RefundTicketService rtSvc = new RefundTicketService();
			rtSvc.updateOneDt(tkDtID);
			
			Gson gson = new Gson();
			res.setContentType("text/json; charset=UTF-8");
			res.getWriter().write(gson.toJson(ordVO));
		}
		
	}

}
