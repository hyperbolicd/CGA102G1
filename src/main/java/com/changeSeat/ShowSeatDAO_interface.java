package com.changeSeat;

import java.util.List;

import com.hall.model.HallVO;

public interface ShowSeatDAO_interface {
	
	public List getDate(Integer hlId); 

	public List<ShowSeatVO> getTimeByDate(Integer hlId,String dateOption);
	
	public ShowSeatVO getShowByTime(Integer SH_ID);
	
	public HallVO getSeatByHL(Integer hlId);
	
}
