package com.act.model;

import java.sql.Date;
import java.util.*;

import com.actdt.model.ActdtVO;

public class ActService {
	private ActDAO_interface dao;
	
	public ActService() {
		dao = new ActJDBCDAO();
	}
	
	public ActVO addAct(Integer act_id, byte[] act_picture, String act_subtitle, String act_content,
			Date act_date_start, Date act_date_end) {
		
		ActVO actVO = new ActVO();
		
		actVO.setAct_picture(act_picture);
		actVO.setAct_subtitle(act_subtitle);
		actVO.setAct_content(act_content);
		actVO.setAct_date_start(act_date_start);
		actVO.setAct_date_end(act_date_end);
		dao.insert(actVO);
		
		return actVO;
	}
	
	public ActVO updateAct(Integer act_id, byte[] act_picture, String act_subtitle, String act_content,
			Date act_date_start, Date act_date_end) {
		
		ActVO actVO = new ActVO();
		
		actVO.setAct_picture(act_picture);
		actVO.setAct_subtitle(act_subtitle);
		actVO.setAct_content(act_content);
		actVO.setAct_date_start(act_date_start);
		actVO.setAct_date_end(act_date_end);
		
		dao.update(actVO);
		
		return actVO;
	}
	
	public void deleteAct(Integer act_id) {
		dao.delete(act_id);
	}

	public ActVO getOneAct(Integer act_id) {
		return dao.findByPrimaryKey(act_id);
	}

	public List<ActVO> getAll() {
		return dao.getAll();
	}
	
	public ActVO findByPrimaryKey(Integer act_id) {
		
		return dao.findByPrimaryKey(act_id);
	}
	
	
	public Set<ActdtVO> getActdtStatus(Byte act_status) {
		return dao.getActdtStatus(act_status);
	}


	
}
	
