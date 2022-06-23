package com.tk_ord.model;

import java.util.List;

public class TkOrdService {
	
	private TkOrdDAO_interface dao;

	public TkOrdService() {
		dao = new TkOrdJDBCDAO();
//		dao = new TkOrdDAO();
	}

	public TkOrdVO addTkOrd(Integer memberID, Integer shID) {

		TkOrdVO tkOrdVO = new TkOrdVO();

		tkOrdVO.setMemberID(memberID);
		tkOrdVO.setShID(shID);

		dao.insert(tkOrdVO);

		return tkOrdVO;
	}

	//預留給 Struts 2 或 Spring MVC 用
	public void addTkOrd(TkOrdVO tkOrdVO) {
		dao.insert(tkOrdVO);
	}
	
	public TkOrdVO updateTkOrd(Long tkOrdID, Integer memberID, Integer shID) {

		TkOrdVO tkOrdVO = new TkOrdVO();

		tkOrdVO.setTkOrdID(tkOrdID);
		tkOrdVO.setMemberID(memberID);
		tkOrdVO.setShID(shID);
		dao.update(tkOrdVO);

		return dao.findByPrimaryKey(tkOrdID);
	}
	
	//預留給 Struts 2 用的
	public void updateTkOrd(TkOrdVO tkOrdVO) {
		dao.update(tkOrdVO);
	}

	public void deleteTkOrd(Long tkOrdID) {
		dao.delete(tkOrdID);
	}

	public TkOrdVO getOneTkInf(Long tkOrdID) {
		return dao.findByPrimaryKey(tkOrdID);
	}

	public List<TkOrdVO> getAll() {
		return dao.getAll();
	}

}
