package com.actdt.model;

import java.sql.Date;
import java.util.*;


public class ActdtService {

	private ActdtDAO_interface dao;

	public ActdtService() {
		dao = new ActdtJDBCDAO();
	}

	public ActdtVO insert(Integer act_id,Date act_date_start, String act_title, String act_subtitle, Integer tkTypeID, Double act_discount, Integer act_coupon, Byte act_status, String act_content, byte[] act_picture) {

		ActdtVO actdtVO = new ActdtVO();
		
		actdtVO.setAct_id(act_id);
		actdtVO.setAct_date_start(act_date_start);
		actdtVO.setAct_title(act_title);
		actdtVO.setAct_subtitle(act_subtitle);
		actdtVO.setTkTypeID(tkTypeID);
		actdtVO.setAct_discount(act_discount);
		actdtVO.setAct_coupon(act_coupon);
		actdtVO.setAct_status(act_status);
		actdtVO.setAct_content(act_content);
		actdtVO.setAct_picture(act_picture);
		dao.insert(actdtVO);

		return actdtVO;
	}

	public ActdtVO update (Integer act_id,Date act_date_start, String act_title, String act_subtitle, Integer tkTypeID, Double act_discount, Integer act_coupon, Byte act_status, String act_content, byte[] act_picture) {

		ActdtVO actdtVO = new ActdtVO();
		
		actdtVO.setAct_id(act_id);
		actdtVO.setAct_date_start(act_date_start);
		actdtVO.setAct_title(act_title);
		actdtVO.setAct_subtitle(act_subtitle);
		actdtVO.setTkTypeID(tkTypeID);
		actdtVO.setAct_discount(act_discount);
		actdtVO.setAct_coupon(act_coupon);
		actdtVO.setAct_status(act_status);
		actdtVO.setAct_content(act_content);
		actdtVO.setAct_picture(act_picture);
		dao.update(actdtVO);

		return actdtVO;
	}

	public void delete(Integer act_id, Integer tkTypeID) {
		dao.delete(act_id, tkTypeID);
	}

	public ActdtVO findByPrimaryKey(Integer act_id,Integer tkTypeID) {
		return dao.findByPrimaryKey(act_id, tkTypeID);
	}
	
	public ActdtVO getOneActdt(Integer act_id,Integer tkTypeID) {
		return dao.findByPrimaryKey(act_id, tkTypeID);
	}

	public List<ActdtVO> getAll() {
		return dao.getAll();
	}
	
	public List<ActdtVO> getActdtStatus() {
		return dao.getAll();
	}
	
	
}



