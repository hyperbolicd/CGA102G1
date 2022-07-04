package com.cmt.model;

import java.sql.Timestamp;
import java.util.*;

public class CmtService {

	private CmtDAO_interface dao;

	public CmtService() {
		dao = new CmtJDBCDAO();
	}
	
	public CmtVO addCmt(Integer MEMBER_ID, Integer MV_ID, String CM_TEXT,
			Integer CM_LIKE, Integer CM_STAR, Integer CM_STATE, Timestamp CM_DATE) {

		CmtVO cmtVO = new CmtVO();

		cmtVO.setMEMBER_ID(MEMBER_ID);
		cmtVO.setMV_ID(MV_ID);
		cmtVO.setCM_TEXT(CM_TEXT);
		cmtVO.setCM_LIKE(CM_LIKE);
		cmtVO.setCM_STAR(CM_STAR);
		cmtVO.setCM_STATE(CM_STATE);
		cmtVO.setCM_DATE(CM_DATE);
		dao.insert(cmtVO);

		return cmtVO;
	}
	
	public CmtVO updateCmt(Integer MEMBER_ID, Integer MV_ID, String CM_TEXT,
			Integer CM_LIKE, Integer CM_STAR, Integer CM_STATE, Timestamp CM_DATE) {
		
		CmtVO cmtVO = new CmtVO();
		
		cmtVO.setMEMBER_ID(MEMBER_ID);
		cmtVO.setMV_ID(MV_ID);
		cmtVO.setCM_TEXT(CM_TEXT);
		cmtVO.setCM_LIKE(CM_LIKE);
		cmtVO.setCM_STAR(CM_STAR);
		cmtVO.setCM_STATE(CM_STATE);
		cmtVO.setCM_DATE(CM_DATE);
		dao.update(cmtVO);
		
		return cmtVO;
	}

	public List<CmtVO> getAll() {
		return dao.getAll();
	}

	public CmtVO getOneCmt(Integer CM_ID) {
		return dao.findByPrimaryKey(CM_ID);
	}

	public List<CmtVO> getCmtsByMV_ID(Integer MV_ID) {
		return dao.getCmtsByMV_ID(MV_ID);
	}

	public void deleteCmt(Integer CM_ID) {
		dao.delete(CM_ID);
	}
	
	public void updateCmtState(Integer CM_ID,Integer CM_STATE) {
		dao.updateCmtState(CM_ID, CM_STATE);
	}

}
