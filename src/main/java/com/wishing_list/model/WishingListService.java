package com.wishing_list.model;

import java.util.List;

public class WishingListService {
	WishingListDAO_interface dao;
	
	public WishingListService() {
		dao = new WishingListJDBCDAO();
		// 連線池版
//		dao = new WishingPondDAO();
	}
	
	public WishingListVO addWishingPond(Integer wish_no, Integer mv_id) {
		WishingListVO wishingPondVO = new WishingListVO();
		wishingPondVO.setWish_no(wish_no);
		wishingPondVO.setMv_id(mv_id);
		dao.insert(wishingPondVO);
		
		return wishingPondVO;
	}
	
	public void addWishingPond(WishingListVO wishingPondVO) {
		dao.insert(wishingPondVO);
	}
	
	public void updateWishingPond(Integer wish_no, Integer mv_id, Integer wish_count) {
		WishingListVO wishingPondVO = new WishingListVO();
		wishingPondVO.setWish_no(wish_no);
		wishingPondVO.setMv_id(mv_id);
		wishingPondVO.setWish_count(wish_count);
		dao.update(wishingPondVO);
	}
	
	public void updateWishingPond(WishingListVO wishingPondVO) {
		dao.update(wishingPondVO);
	}
	
	public void deleteWishingPond(Integer wish_no, Integer mv_id) {
		dao.delete(wish_no, mv_id);
	}
	
	public List<WishingListVO> getOneWishingPond(Integer wish_no) {
		return dao.findByWishNo(wish_no);
	}

	public List<WishingListVO> getAll(){
		return dao.getAll();
	}

}
