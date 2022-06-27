package com.wishing_list.model;

import java.util.*;

public interface WishingListDAO_interface {
	public void insert(WishingListVO wishingPondVO);
	public void delete(Integer wishNo, Integer wishOption);
	public void update(WishingListVO wishingPondVO);
	public List<WishingListVO> findByWishNo(Integer wishNo); 
	public List<WishingListVO> getAll(); 
}
