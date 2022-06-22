package com.tk_ord.model;

import java.util.List;

public interface TkOrdDAO_interface {
	public void insert(TkOrdVO tkOrdVO);
    public void update(TkOrdVO tkOrdVO);
    public void delete(Long tkOrdID);
    public TkOrdVO findByPrimaryKey(Long tkOrdID);
    public List<TkOrdVO> getAll();
  //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<TkOrdVO> getAll(Map<String, String[]> map); 


}
