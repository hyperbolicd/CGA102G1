package com.merchandise_order.model;

import java.util.List;

public interface MerchOrdDAO_interface {
	public void insert(MerchOrdVO merchOrdVo);
	public void update(MerchOrdVO merchOrdVo);
	public void delete(Integer merchOrdID);
	public MerchOrdVO findByPrimaryKey(Integer merchOrdID);
	public List<MerchOrdVO> getAll();
	//複合查詢
	//public List<MerchVO> getAll(Map<String, String[]> map);
}
