package com.actdt.model;

import java.util.List;

import com.merchandise_inf.model.MerchVO;

public class ActdtService {

	private ActdtDAO_interface dao;

	public ActdtService() {
		dao = new ActdtJDBCDAO();
	}

	public ActdtVO insert(Integer act_id, String act_title, Integer tkTypeID, Double act_discount, Integer act_coupon, Byte act_status) {

		ActdtVO actdtVO = new ActdtVO();
		
		actdtVO.setAct_id(act_id);
		actdtVO.setAct_title(act_title);
		actdtVO.settkTypeID(tkTypeID);
		actdtVO.setAct_discount(act_discount);
		actdtVO.setAct_coupon(act_coupon);
		actdtVO.setAct_status(act_status);
		dao.insert(actdtVO);

		return actdtVO;
	}

	public ActdtVO update(Integer act_id, String act_title, Integer tkTypeID, Double act_discount, Integer act_coupon, Byte act_status) {

		ActdtVO actdtVO = new ActdtVO();
		
		actdtVO.setAct_id(act_id);
		actdtVO.setAct_title(act_title);
		actdtVO.settkTypeID(tkTypeID);
		actdtVO.setAct_discount(act_discount);
		actdtVO.setAct_coupon(act_coupon);
		actdtVO.setAct_status(act_status);
		dao.update(actdtVO);

		return actdtVO;
	}

	public void delete(Integer act_id, Integer tkTypeID) {
		dao.delete(act_id, tkTypeID);
	}

	public ActdtVO findByPrimaryKey(Integer act_id,Integer tkTypeID) {
		return dao.findByPrimaryKey(act_id, tkTypeID);
	}

	public List<ActdtVO> getAll() {
		return dao.getAll();
	}
	
	public List<ActdtVO> getActdtStatus() {
		return dao.getAll();
	}
	
	
}



