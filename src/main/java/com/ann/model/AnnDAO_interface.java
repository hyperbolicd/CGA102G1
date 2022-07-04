package com.ann.model;

import java.util.*;

public interface AnnDAO_interface {

	public void insert(AnnVO annVO);
	public void update(AnnVO annVO);
	public void delete(Integer ann_no);
	
	public AnnVO findByPrimaryKey(Integer ann_no);
	public List<AnnVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	//public List<EmpVO> getAll(Map<String, String[]> map); 
	
}
