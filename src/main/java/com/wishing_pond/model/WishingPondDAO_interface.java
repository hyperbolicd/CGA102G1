package com.wishing_pond.model;

import java.util.*;

public interface WishingPondDAO_interface {
	public void insert(WishingPondVO wishingPondVO);
	public void delete(Integer wishNo, Integer wishOption);
	public void update(WishingPondVO wishingPondVO);
	public List<WishingPondVO> findByWishNo(Integer wishNo); 
	public List<WishingPondVO> getAll(); 
}
