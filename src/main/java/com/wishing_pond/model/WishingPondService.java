package com.wishing_pond.model;

import java.sql.Timestamp;
import java.util.List;

public class WishingPondService {
	WishingPondDAO_interface dao;
	
	public WishingPondService() {
		dao = new WishingPondJDBCDAO();
		// 連線池版
//		dao = new WishingPondDAO();
	}
	
	public WishingPondVO addWishingPond(Integer wish_no, Integer wish_option, Integer mv_id,
								Integer wish_count,	Timestamp wish_start, Timestamp wish_end) {
		WishingPondVO wishingPondVO = new WishingPondVO();
		wishingPondVO.setWish_no(wish_no);
		wishingPondVO.setWish_option(wish_option);
		wishingPondVO.setMv_id(mv_id);
		wishingPondVO.setWish_count(wish_count);
		wishingPondVO.setWish_start(wish_start);
		wishingPondVO.setWish_end(wish_end);
		dao.insert(wishingPondVO);
		
		return wishingPondVO;
	}
	
	public void addWishingPond(WishingPondVO wishingPondVO) {
		dao.insert(wishingPondVO);
	}
	
	public void updateWishingPond(Integer wish_no, Integer wish_option, Integer mv_id,
			Integer wish_count,	Timestamp wish_start, Timestamp wish_end) {
		WishingPondVO wishingPondVO = new WishingPondVO();
		wishingPondVO.setWish_no(wish_no);
		wishingPondVO.setWish_option(wish_option);
		wishingPondVO.setMv_id(mv_id);
		wishingPondVO.setWish_count(wish_count);
		wishingPondVO.setWish_start(wish_start);
		wishingPondVO.setWish_end(wish_end);
		dao.update(wishingPondVO);
	}
	
	public void updateWishingPond(WishingPondVO wishingPondVO) {
		dao.update(wishingPondVO);
	}
	
	public void deleteWishingPond(Integer wish_no, Integer wish_option) {
		dao.delete(wish_no, wish_option);
	}
	
	public List<WishingPondVO> getOneWishingPond(Integer wish_no) {
		return dao.findByWishNo(wish_no);
	}

	public List<WishingPondVO> getAll(){
		return dao.getAll();
	}

}
