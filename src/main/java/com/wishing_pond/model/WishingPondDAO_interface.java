package com.wishing_pond.model;

import java.util.*;

public interface WishingPondDAO_interface {
	public void insert(WishingPondVO wishingPondVO);
	public void delete(Integer wishNo);
	public void update(WishingPondVO wishingPondVO);
	public WishingPondVO findByWishNo(Integer wishNo); 
	public List<WishingPondVO> getAll();
	// 複合查詢
	public List<WishingPondVO> getAll(Map<String, String[]> map);
}
