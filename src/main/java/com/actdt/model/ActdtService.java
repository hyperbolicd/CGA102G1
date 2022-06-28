package com.actdt.model;

import java.util.List;

public class ActdtService {

	private ActdtDAO_interface dao;

	public ActdtService() {
		dao = new ActdtJDBCDAO();
	}

	public ActdtVO addActdt(Integer act_id, Integer tk_type_id, Double act_discount, Integer act_coupon) {

		ActdtVO actdtVO = new ActdtVO();
		
		actdtVO.setAct_id(act_id);
		actdtVO.setTk_type_id(tk_type_id);
		actdtVO.setAct_discount(act_discount);
		actdtVO.setAct_coupon(act_coupon);
		dao.insert(actdtVO);

		return actdtVO;
	}

	public ActdtVO updateActdt(Integer act_id, Integer tk_type_id, Double act_discount, Integer act_coupon) {

		ActdtVO actdtVO = new ActdtVO();
		
		actdtVO.setAct_id(act_id);
		actdtVO.setTk_type_id(tk_type_id);
		actdtVO.setAct_discount(act_discount);
		actdtVO.setAct_coupon(act_coupon);
		dao.update(actdtVO);

		return actdtVO;
	}

	public void deleteActdt(Integer act_id) {
		dao.delete(act_id);
	}

	public ActdtVO getOneActdt(Integer act_id) {
		return dao.findByPrimaryKey(act_id);
	}

	public List<ActdtVO> getAll() {
		return dao.getAll();
	}
}
