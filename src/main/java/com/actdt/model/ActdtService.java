package com.actdt.model;

import java.util.List;

import com.merchandise_inf.model.MerchVO;

public class ActdtService {

	private ActdtDAO_interface dao;

	public ActdtService() {
		dao = new ActdtJDBCDAO();
	}

	public ActdtVO insert(Integer act_id, String act_title, Integer tk_type_id, Double act_discount, Integer act_coupon, Byte act_status) {

		ActdtVO actdtVO = new ActdtVO();
		
		actdtVO.setAct_id(act_id);
		actdtVO.setAct_title(act_title);
		actdtVO.setTk_type_id(tk_type_id);
		actdtVO.setAct_discount(act_discount);
		actdtVO.setAct_coupon(act_coupon);
		actdtVO.setAct_status(act_status);
		dao.insert(actdtVO);

		return actdtVO;
	}

	public ActdtVO update(Integer act_id, String act_title, Integer tk_type_id, Double act_discount, Integer act_coupon, Byte act_status) {

		ActdtVO actdtVO = new ActdtVO();
		
		actdtVO.setAct_id(act_id);
		actdtVO.setAct_title(act_title);
		actdtVO.setTk_type_id(tk_type_id);
		actdtVO.setAct_discount(act_discount);
		actdtVO.setAct_coupon(act_coupon);
		actdtVO.setAct_status(act_status);
		dao.update(actdtVO);

		return actdtVO;
	}

	public void delete(Integer act_id) {
		dao.delete(act_id);
	}

	public ActdtVO findByPrimaryKey(Integer act_id) {
		return dao.findByPrimaryKey(act_id);
	}

	public List<ActdtVO> getAll() {
		return dao.getAll();
	}
	
	public List<ActdtVO> getActdtStatus() {
		return dao.getAll();
	}
	
	
}







//package com.actdt.model;
//
//import java.util.List;
//
//
//public class ActdtService {
//	
//	private ActdtDAO_interface dao;
//
//	public ActdtService() {
//		dao = new ActdtJDBCDAO();
////		dao = new TkOrdDAO();
//	}
//
//	public ActdtVO addActdt(Integer act_id, String act_title, Integer tk_type_id, Double act_discount, Integer act_coupon, Byte act_status) {
//
//		ActdtVO actdtVO = new ActdtVO();
//		
//		actdtVO.setAct_id(act_id);
//		actdtVO.setAct_title(act_title);
//		actdtVO.setTk_type_id(tk_type_id);
//		actdtVO.setAct_discount(act_discount);
//		actdtVO.setAct_coupon(act_coupon);
//		actdtVO.setAct_status(act_status);
//		dao.insert(actdtVO);
//
//		return actdtVO;
//	}
//
//	//預留給 Struts 2 或 Spring MVC 用
//	public void addActdt(ActdtVO actdtVO) {
//		dao.insert(actdtVO);
//	}
//	
//	public ActdtVO updateActdt(Integer act_id, String act_title, Integer tk_type_id, Double act_discount, Integer act_coupon, Byte act_status) {
//
//		ActdtVO actdtVO = new ActdtVO();
//		
//		actdtVO.setAct_id(act_id);
//		actdtVO.setAct_title(act_title);
//		actdtVO.setTk_type_id(tk_type_id);
//		actdtVO.setAct_discount(act_discount);
//		actdtVO.setAct_coupon(act_coupon);
//		actdtVO.setAct_status(act_status);
//		dao.update(actdtVO);
//
//		//return actdtVO;
//
//		return dao.findByPrimaryKey(act_id);
//		
//	}
//	
//	//預留給 Struts 2 用的
//	public void updateActdt(ActdtVO actdtVO) {
//		dao.update(actdtVO);
//	}
//
//	public void deleteActdt(Integer act_id) {
//		dao.delete(act_id);
//	}
//
//	public ActdtVO getOneActdt(Integer act_id) {
//		return dao.findByPrimaryKey(act_id);
//	}
//
//	public List<ActdtVO> getAll() {
//		return dao.getAll();
//	}
//	
//	
//	public void insertWithTkOrdDtsAndFdOrdDts(TkOrdVO tkOrdVO , List<TkOrdDtVO> list , List<FdOrdDtVO> list2) {
//
//		
//	}
//
//}

