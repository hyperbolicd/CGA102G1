package com.sc_detail.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import com.member.model.MemberService;
import com.member.model.MemberVO;
import com.merchandise_inf.model.MerchService;
import com.merchandise_inf.model.MerchVO;
import com.merchandise_order.model.MerchOrdService;
import com.merchandise_order.model.MerchOrdVO;
import com.order_detail.model.OrderDetailVO;
import com.sc_detail.model.SCDetailService;
import com.sc_detail.model.SCDetailVO;

import oracle.net.aso.i;

@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShoppingCartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		@SuppressWarnings("unchecked")
		List<SCDetailVO> buylist = (Vector<SCDetailVO>) session.getAttribute("shoppingcart");
		
			// 刪除購物車中的書籍
			if ("delete".equals(action)) {
				String del = req.getParameter("del");
				int d = Integer.parseInt(del);
				buylist.remove(d);
				session.setAttribute("shoppingcart", buylist);
				String url = "/front_end/merchandise/cart.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, res);
			} else if ("add".equals(action)) {
				// 取得後來新增的書籍
				SCDetailVO scDetailVo = getscDetailVO(req);

				if (buylist == null) {
					buylist = new Vector<SCDetailVO>();
					buylist.add(scDetailVo);
				} else {
					if (buylist.contains(scDetailVo)) {
						SCDetailVO innerSCDetailVo = buylist.get(buylist.indexOf(scDetailVo));
						innerSCDetailVo.setScCount((innerSCDetailVo.getScCount() + scDetailVo.getScCount()));
					} else {
						buylist.add(scDetailVo);
					}
				}
				session.setAttribute("shoppingcart", buylist);
				String url = "/front_end/merchandise/cart.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, res);
			}
			
			
			/*購物車購物*/
			if ("insertfromcart".equals(action)) {
				/* =========================接受請求參數===================================== */
				Map<String, String[]> map = req.getParameterMap();
				List<OrderDetailVO> list = new LinkedList<OrderDetailVO>();
				MerchOrdService merchOrdSvc = new MerchOrdService();
				MerchService merchSvc = new MerchService();
				MemberService memberSvc = new MemberService();
				int item = 1;
				Integer memberID = 0;
				for (int i = 0; i < map.get("pay").length; i++) {
					Integer index = Integer.valueOf(map.get("pay")[i]);
					SCDetailVO scDetailVo = buylist.get(index);
					OrderDetailVO orderDetailVo = new OrderDetailVO();
					orderDetailVo.setItem(item);
					item++;
					Integer merchID = scDetailVo.getMerchID();
					orderDetailVo.setMerchID(merchID);

					Integer merchCount =Integer.valueOf(map.get("count")[index]);
					orderDetailVo.setOrdCount(merchCount);

					MerchVO merchVo = merchSvc.getOneMerch(merchID);
					Double merchPrice = merchVo.getMerchPrice();
					orderDetailVo.setOrdPrice(merchPrice);

					/* 0:備貨中 1:可取貨 2:已完成 3:已取消 */
					Byte ordStatus = 0;
					orderDetailVo.setOrdStatus(ordStatus);
					list.add(orderDetailVo);

					memberID = scDetailVo.getMemberID();
				}
				Double merchOrdCount = Double.valueOf(map.get("totalCount")[0]);

				/* 0:處理中 1:可取貨 2:已完成 3:已取消 */
				Byte merchOrdStatus = 0;

				/* =========================開始修改資料================================= */
				MerchOrdVO merchOrdVo = new MerchOrdVO(memberID, null, merchOrdCount, merchOrdStatus);
				merchOrdSvc.insertWithOrderDetail(merchOrdVo, list);
				/*移除購物車內已購買的內容*/
				for(int i = map.get("pay").length-1; i >= 0 ; i--) {
					buylist.remove(Integer.parseInt(map.get("pay")[i]));
				}
				/* =========================修改完成,準備轉交============================= */

				session.setAttribute("shoppingcart", buylist);
				String url = "/front_end/merchandise/cart.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, res);
			}
			
			
			/*商品頁購物*/
			if("payForOneMerch".equals(action)) {
				Map<String, String[]> map = req.getParameterMap();
				List<OrderDetailVO> list = new LinkedList<OrderDetailVO>();
				MerchOrdService merchOrdSvc = new MerchOrdService();
				MerchService merchSvc = new MerchService();
				MemberService memberSvc = new MemberService();
				int item = 1;
				Integer merchID = Integer.valueOf(map.get("merchID")[0]);
				Integer memberID = Integer.valueOf(map.get("memberID")[0]);
				OrderDetailVO orderDetailVo = new OrderDetailVO();
				orderDetailVo.setItem(item);
				orderDetailVo.setMerchID(merchID);
				Integer merchCount =Integer.valueOf(map.get("scCount")[0]);
				orderDetailVo.setOrdCount(merchCount);
				MerchVO merchVo = merchSvc.getOneMerch(merchID);
				Double merchPrice = merchVo.getMerchPrice();
				orderDetailVo.setOrdPrice(merchPrice);
				/* 0:備貨中 1:可取貨 2:已完成 3:已取消 */
				Byte ordStatus = 0;
				orderDetailVo.setOrdStatus(ordStatus);
				list.add(orderDetailVo);
				Double merchOrdCount = (merchVo.getMerchPrice() * merchCount);
				/* 0:處理中 1:可取貨 2:已完成 3:已取消 */
				Byte merchOrdStatus = 0;
				/* =========================開始修改資料================================= */
				MerchOrdVO merchOrdVo = new MerchOrdVO(memberID, null, merchOrdCount, merchOrdStatus);
				merchOrdSvc.insertWithOrderDetail(merchOrdVo, list);
				
				String url = "/front_end/merchandise/cart.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, res);
			}
		
			
			
		
		// 查看購物車
		if ("checkout".equals(action)) {
			double total = 0;
			for (int i = 0; i < buylist.size(); i++) {
				SCDetailVO scDetailVo = buylist.get(i);
				Double price = scDetailVo.getMerchVO().getMerchPrice();
				Integer scCount = scDetailVo.getScCount();
				total += scCount * price;
			}
			String amount = String.valueOf(total);
			req.setAttribute("amount", amount);
			String url = "/front_end/merchandise/cart.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}
	}

	public SCDetailVO getscDetailVO(HttpServletRequest req) {
		SCDetailVO scDetailVo = new SCDetailVO();
		Integer memberID = Integer.valueOf(req.getParameter("memberID"));
		Integer merchID = Integer.valueOf(req.getParameter("merchID"));
		Integer scCount = Integer.valueOf(req.getParameter("scCount"));

		scDetailVo.setMemberID(memberID);
		scDetailVo.setMerchID(merchID);
		scDetailVo.setScCount(scCount);

		return scDetailVo;
	}

}