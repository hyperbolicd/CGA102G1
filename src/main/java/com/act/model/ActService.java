package com.act.model;

import java.sql.Timestamp;
import java.util.List;

public class ActService {

	private ActDAO_interface dao;

	public ActService() {
		dao = new ActJDBCDAO();
	}

	public ActVO addAct(byte[] act_picture, String act_title, String act_subtitle, String act_content, 
			Timestamp act_time_start, Timestamp act_time_end, Byte act_status) {

		ActVO actVO = new ActVO();

		actVO.setAct_picture(act_picture);
		actVO.setAct_title(act_title);
		actVO.setAct_subtitle(act_subtitle);
		actVO.setAct_content(act_content);
		actVO.setAct_time_start(act_time_start);
		actVO.setAct_time_end(act_time_end);
		actVO.setAct_status(act_status);
		dao.insert(actVO);

		return actVO;
	}

	public ActVO updateAct(Integer act_id, byte[] act_picture, String act_title, String act_subtitle, String act_content, 
			Timestamp act_time_start, Timestamp act_time_end, Byte act_status) {

		ActVO actVO = new ActVO();

		actVO.setAct_id(act_id);
		actVO.setAct_picture(act_picture);
		actVO.setAct_title(act_title);
		actVO.setAct_subtitle(act_subtitle);
		actVO.setAct_content(act_content);
		actVO.setAct_time_start(act_time_start);
		actVO.setAct_time_end(act_time_end);
		actVO.setAct_status(act_status);
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
	
	public void actStatus(Integer act_id) {
		dao.actStatus(act_id);
	}
	
}
