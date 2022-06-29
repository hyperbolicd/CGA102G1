package com.wishing_pond.model;

import java.util.*;

import com.wishing_list.model.WishingListVO;

public interface WishingPondDAO_interface {
	public void insert(WishingPondVO wishingPondVO);
	public Integer insertWithOptions(WishingPondVO wishingPondVO, List<WishingListVO> list);
	public void delete(Integer wishNo);
	public void update(WishingPondVO wishingPondVO);
	public void updateWithOptions(WishingPondVO wishingPondVO, List<WishingListVO> list);
	public WishingPondVO findByWishNo(Integer wishNo); 
	public List<WishingPondVO> getAll();
	// 複合查詢
	public List<WishingPondVO> getAll(Map<String, String[]> map);
	// 判斷是否可修改
	public boolean updatable(Integer wishNo);
	public Integer getNextId(); 
}
