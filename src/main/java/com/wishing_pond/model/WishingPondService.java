package com.wishing_pond.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class WishingPondService {
	WishingPondDAO_interface dao;
	
	public WishingPondService() {
		dao = new WishingPondJDBCDAO();
		// 連線池版
//		dao = new WishingPondDAO();
	}
	
	public WishingPondVO addWishingPond(String wish_name, Timestamp wish_start, Timestamp wish_end) {
		WishingPondVO wishingPondVO = new WishingPondVO();
		wishingPondVO.setWish_name(wish_name);
		wishingPondVO.setWish_start(wish_start);
		wishingPondVO.setWish_end(wish_end);
		dao.insert(wishingPondVO);
		
		return wishingPondVO;
	}
	
	public void addWishingPond(WishingPondVO wishingPondVO) {
		dao.insert(wishingPondVO);
	}
	
	public void updateWishingPond(Integer wish_no, String wish_name, 
			Timestamp wish_start, Timestamp wish_end) {
		WishingPondVO wishingPondVO = new WishingPondVO();
		wishingPondVO.setWish_no(wish_no);
		wishingPondVO.setWish_name(wish_name);
		wishingPondVO.setWish_start(wish_start);
		wishingPondVO.setWish_end(wish_end);
		dao.update(wishingPondVO);
	}
	
	public void updateWishingPond(WishingPondVO wishingPondVO) {
		dao.update(wishingPondVO);
	}
	
	public void deleteWishingPond(Integer wish_no) {
		dao.delete(wish_no);
	}
	
	public WishingPondVO getOneWishingPond(Integer wish_no) {
		return dao.findByWishNo(wish_no);
	}

	public List<WishingPondVO> getAll(){
		return dao.getAll();
	}
	// 複合查詢
	public List<WishingPondVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

}
