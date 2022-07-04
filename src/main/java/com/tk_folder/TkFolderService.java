package com.tk_folder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.changeSeat.ShowSeatService;
import com.changeSeat.ShowSeatVO;
import com.hall.model.HallService;
import com.hall.model.HallVO;
import com.movie.model.MovieService;
import com.movie.model.MovieVO;
import com.tk_ord.model.TkOrdVO;
import com.tk_ord_dt.model.TkOrdDtVO;

public class TkFolderService {
	private TkFolder_interface dao;
	
	public TkFolderService (){
		dao = new TkFolderDAO();
	}
	
	public Map listAllOrdInf(Integer member_ID) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		// 找到該會員全部的訂單VO 裝進list
		List<TkOrdVO> OrdVOList = dao.getAllTkOrd(member_ID);
		// 設置一個裝場次VO的list
		List<ShowSeatVO> showList = new ArrayList<ShowSeatVO>();
		// 設置一個裝電影VO的list
		List<MovieVO> mvList = new ArrayList<MovieVO>();
		// 設置一個裝廳院VO的list
		List<HallVO> hlList = new ArrayList<HallVO>();
		
		// 使用tkOrdVO的SH_ID找到場次的時間 廳院 播放電影
		ShowSeatService ssSvc = new ShowSeatService();
		HallService hlSvc = new HallService();
		MovieService mvSvc = new MovieService();
		
		for (TkOrdVO tkOrdVO : OrdVOList) {
			
			// 找到場次VO (取場次時間)
			ShowSeatVO showSeatVO = ssSvc.getShowByTime(tkOrdVO.getShID());
			showList.add(showSeatVO);
			
			// 利用場次VO的SH_ID找到廳院VO (取廳院名)
			HallVO hallVO = hlSvc.findByPrimaryKey(showSeatVO.getHL_ID());
			hlList.add(hallVO);
			
			// 利用場次VO的MV_ID找到電影VO
			MovieVO movieVO = mvSvc.findByPrimaryKey(showSeatVO.getmvId());
			mvList.add(movieVO);
		}
		map.put("OrdVOList", OrdVOList);
		map.put("showList", showList);
		map.put("hlList", hlList);
		map.put("mvList", mvList);
		
		return map;
	}
}
