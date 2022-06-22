package com.report.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.report.model.ReportService;
import com.report.model.ReportVO;

@WebServlet("/ReportServlet.do")
public class ReportServlet extends HttpServlet {
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		String action = req.getParameter("action");
		
		if("insert".equals(action)) {
			
			Integer cmId = Integer.valueOf(req.getParameter("cmId"));
			Integer memberId = Integer.valueOf(req.getParameter("memberId"));
			String rpText = req.getParameter("rpText");
			String rpType = req.getParameter("rpType");
			Integer rpState = Integer.valueOf(req.getParameter("rpState"));
			Timestamp rpDate = java.sql.Timestamp.valueOf(req.getParameter("rpDate"));
			/* **************************************************************** */
			
			ReportVO reportVO = new ReportVO();
			reportVO.setCmId(cmId);
			reportVO.setMemberId(memberId);
			reportVO.setRpText(rpText);
			reportVO.setRpType(rpType);
			reportVO.setRpState(rpState);
			reportVO.setRpDate(rpDate);
			
			ReportService rpSvc = new ReportService();
			reportVO = rpSvc.insert(cmId, memberId, rpText, rpType, rpState, rpDate);
			
			String url = "";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
			
		}
		if("getOne_For_Update".equals(action)) {
			
			Integer rpId = Integer.valueOf(req.getParameter("rpId"));
			
			ReportService rpSvc = new ReportService();
			ReportVO reportVO = rpSvc.findByPrimaryKey(rpId);
			
			req.setAttribute("reportVO", reportVO);
			String url = "";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
			
		}
		if("update".equals(action)) {
			
			Integer rpId = Integer.valueOf(req.getParameter("rpId"));
			Integer cmId = Integer.valueOf(req.getParameter("cmId"));
			Integer memberId = Integer.valueOf(req.getParameter("memberId"));
			String rpText = req.getParameter("rpText");
			String rpType = req.getParameter("rpType");
			Integer rpState = Integer.valueOf(req.getParameter("rpState"));
			Timestamp rpDate = java.sql.Timestamp.valueOf(req.getParameter("rpDate"));
			/* **************************************************************** */
			
			ReportVO reportVO = new ReportVO();
			reportVO.setRpId(rpId);
			reportVO.setCmId(cmId);
			reportVO.setMemberId(memberId);
			reportVO.setRpText(rpText);
			reportVO.setRpType(rpType);
			reportVO.setRpState(rpState);
			reportVO.setRpDate(rpDate);
			/* **************************************************************** */
			
			ReportService rpSvc = new ReportService();
			reportVO = rpSvc.update(rpId, cmId, memberId, rpText, rpType, rpState, rpDate);
			req.setAttribute("reportVO", reportVO);
			
			String url = "";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}
	}

}
