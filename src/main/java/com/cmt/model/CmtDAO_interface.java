package com.cmt.model;

import java.util.*;


public interface CmtDAO_interface {
	public void insert(CmtVO cmtVO);
	public void update(CmtVO cmtVO);
	public void delete(Integer CM_ID);
    public CmtVO findByPrimaryKey(Integer CM_ID);
    public List<CmtVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<CmtVO> getAll(Map<String, String[]> map); 

}
