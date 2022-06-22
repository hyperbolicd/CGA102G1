package com.tk_ord_dt.model;

import java.util.List;

public class TkOrdDtService {
	
	private TkOrdDtDAO_interface dao;

	public TkOrdDtService() {
		dao = new TkOrdDtJDBCDAO();
//		dao = new TkOrdDtDAO();
	}

	public TkOrdDtVO addTkOrdDt(Long tkOrdID, Integer tkDtID, Integer tkTypeID, Integer actID, java.lang.Byte state,
			String seat, Integer sellPrice) {

		TkOrdDtVO tkOrdDtVO = new TkOrdDtVO();

		tkOrdDtVO.setTkOrdID(tkOrdID);
		tkOrdDtVO.setTkOrdID(tkOrdID);
		tkOrdDtVO.setTkTypeID(tkTypeID);
		tkOrdDtVO.setActID(actID);
		tkOrdDtVO.setState(state);
		tkOrdDtVO.setSeat(seat);
		tkOrdDtVO.setSellPrice(sellPrice);
		dao.insert(tkOrdDtVO);

		return tkOrdDtVO;
	}

	//預留給 Struts 2 或 Spring MVC 用
	public void addTkOrdDt(TkOrdDtVO tkOrdDtVO) {
		dao.insert(tkOrdDtVO);
	}
	
	public TkOrdDtVO updateTkOrdDt(Long tkOrdID, Integer tkDtID, Integer tkTypeID, Integer actID, java.lang.Byte state,
			String seat, Integer sellPrice) {

		TkOrdDtVO tkOrdDtVO = new TkOrdDtVO();

		tkOrdDtVO.setTkOrdID(tkOrdID);
		tkOrdDtVO.setTkOrdID(tkOrdID);
		tkOrdDtVO.setTkTypeID(tkTypeID);
		tkOrdDtVO.setActID(actID);
		tkOrdDtVO.setState(state);
		tkOrdDtVO.setSeat(seat);
		tkOrdDtVO.setSellPrice(sellPrice);
		dao.update(tkOrdDtVO);

		return dao.findByPrimaryKey(tkOrdID, tkDtID);
	}
	
	//預留給 Struts 2 用的
	public void updateTkOrdDt(TkOrdDtVO tkOrdDtVO) {
		dao.update(tkOrdDtVO);
	}

	public void deleteTkOrdDt(Long tkOrdID, Integer tkDtID) {
		dao.delete(tkOrdID, tkDtID);
	}

	public TkOrdDtVO getOneTkOrdDt(Long tkOrdID, Integer tkDtID) {
		return dao.findByPrimaryKey(tkOrdID, tkDtID);
	}

	public List<TkOrdDtVO> getAll() {
		return dao.getAll();
	}

}
